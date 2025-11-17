package day07.ast

import day07.Token

class Assignment(val variable: Token, val expression: Expression) : AST() {
    override fun emit() {
        TODO("Not yet implemented")
    }
}
