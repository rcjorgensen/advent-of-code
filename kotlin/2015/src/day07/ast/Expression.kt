package day07.ast

import day07.Token

sealed class Expression(val operandNames: List<String>) : AST() {

    data class Not(val operand: Token) : Expression(listOf(operand.text)) {
        override fun emit() {
            out.println("${operand.text}.inv()")
        }
    }

    data class And(val leftOperand: Token, val rightOperand: Token) :
        Expression(listOf(leftOperand.text, rightOperand.text)) {
        override fun emit() {
            out.println("${leftOperand.text} and ${rightOperand.text}")
        }
    }

    data class Or(val leftOperand: Token, val rightOperand: Token) :
        Expression(listOf(leftOperand.text, rightOperand.text)) {
        override fun emit() {
            out.println("${leftOperand.text} or ${rightOperand.text}")
        }
    }

    data class LeftShift(val operand: Token, val bitCount: Token) : Expression(listOf(operand.text)) {
        override fun emit() {
            out.println("${operand.text} shl ${bitCount.text}")
        }
    }

    data class RightShift(val operand: Token, val bitCount: Token) : Expression(listOf(operand.text)) {
        override fun emit() {
            out.println("${operand.text} shr ${bitCount.text}")
        }
    }

    data class Const(val operand: Token) : Expression(listOf(operand.text)) {
        override fun emit() {
            out.println(operand.text)
        }
    }
}
