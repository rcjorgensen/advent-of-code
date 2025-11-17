package day07

import day07.ast.Assignment
import day07.ast.Expression
import day07.ast.Program

class Parser(private val scanner: Scanner) {
    fun parseProgram(): Program {
        return Program(parseAssignments())
    }

    private fun parseAssignments(): List<Assignment> {
        val assignments = mutableListOf<Assignment>()
        while (scanner.symbol != Symbol.eof) {
            assignments.add(parseAssignment())
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
        if (scanner.symbol == Symbol.not) {
            matchCurrentSymbol()
            val operand = scanner.token
            matchCurrentSymbol()
            return Expression.Not(operand)
        }

        val leftOperand = scanner.token
        matchCurrentSymbol()
        if (scanner.symbol == Symbol.arrow) {
            return Expression.Const(leftOperand)
        }
        val operator = scanner.token
        matchCurrentSymbol()
        val rightOperand = scanner.token
        matchCurrentSymbol()
        return when (operator.symbol) {
            Symbol.and -> Expression.And(leftOperand, rightOperand)
            Symbol.or -> Expression.Or(leftOperand, rightOperand)
            Symbol.lshift -> Expression.LeftShift(leftOperand, rightOperand)
            Symbol.rshift -> Expression.RightShift(leftOperand, rightOperand)
            else -> error("Invalid operator: $operator")
        }
    }

    private fun matchCurrentSymbol() = scanner.advance()
}
