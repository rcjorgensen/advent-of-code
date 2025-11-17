package day07.ast

import day07.Token

sealed class Expression {
    class Not(val operand: Token) : Expression()
    class And(val leftOperand: Token, val rightOperand: Token) : Expression()
    class Or(val leftOperand: Token, val rightOperand: Token) : Expression()
    class LeftShift(val operand: Token, val bitCount: Token) : Expression()
    class RightShift(val operand: Token, val bitCount: Token) : Expression()
    class Const(val operand: Token) : Expression()
}
