package day07.ast

import day07.Token

data class Assignment(val variable: Token, val expression: Expression) : AST() {
    override fun emit() {
        out.print("    val ${variable.text} = ")
        expression.emit()
    }

    fun dependsOn(other: Assignment): Boolean {
        return this.expression.operandNames.contains(other.variable.text)
    }
}
