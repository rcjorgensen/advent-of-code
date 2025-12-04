package day07

import day07.ast.Assignment
import day07.ast.Expression
import day07.ast.Input

class Parser(private val scanner: Scanner) {
    fun parseInput(): Input {
        return Input(parseAssignments())
    }

    private fun parseAssignments(): List<Assignment> {
        val assignments = mutableListOf<Assignment>()
        while (scanner.symbol != Symbol.EOF) {
            assignments.add(parseAssignment())
        }

        val nodes = mutableListOf<TreeNode>()
        for (assignment in assignments) {
            nodes.add(TreeNode(assignment))
        }

        for (i in 0..<nodes.size - 1) {
            for (j in i + 1..<nodes.size) {
                if (nodes[i].assignment.dependsOn(nodes[j].assignment)) {
                    nodes[i].children.add(nodes[j])
                } else if (nodes[j].assignment.dependsOn(nodes[i].assignment)) {
                    nodes[j].children.add(nodes[i])
                }
            }
        }

        assignments.clear()

        fun visit(treeNode: TreeNode) {
            if (treeNode.visited) {
                return
            }
            for (child in treeNode.children) {
                visit(child)
            }
            assignments.add(treeNode.assignment)
            treeNode.visited = true
        }

        for (node in nodes) {
            visit(node)
        }

        return assignments
    }

    /**
     * Parse the following grammar rule:
     * `assignmentStmt = expression "->" variable .`
     */
    private fun parseAssignment(): Assignment {
        val expression = parseExpression()
        matchCurrentSymbol()
        val variable = scanner.token
        matchCurrentSymbol()
        return Assignment(variable, expression)
    }

    /**
     * Parse the following grammar rule: `expression = NOT operand | leftOperand AND rightOperand | leftOperand OR rightOperand | leftOperand LSHIFT bitCount | leftOperand RSHIFT bitCount . `
     */
    private fun parseExpression(): Expression {
        if (scanner.symbol == Symbol.Not) {
            matchCurrentSymbol()
            val operand = scanner.token
            matchCurrentSymbol()
            return Expression.Not(operand)
        }

        val leftOperand = scanner.token
        matchCurrentSymbol()
        if (scanner.symbol == Symbol.Arrow) {
            return Expression.Const(leftOperand)
        }
        val operator = scanner.token
        matchCurrentSymbol()
        val rightOperand = scanner.token
        matchCurrentSymbol()
        return when (operator.symbol) {
            Symbol.And -> Expression.And(leftOperand, rightOperand)
            Symbol.Or -> Expression.Or(leftOperand, rightOperand)
            Symbol.LShift -> Expression.LeftShift(leftOperand, rightOperand)
            Symbol.RShift -> Expression.RightShift(leftOperand, rightOperand)
            else -> error("Invalid operator: $operator")
        }
    }

    private fun matchCurrentSymbol() = scanner.advance()
}
