package day06

import day06.ast.Input
import day06.ast.MathProblem
import day06.ast.Transformed

class Parser(private val scanner: Scanner) {
    fun parseInput(): Input {
        return Input(parseNumbers(), parseMathOperators())
    }

    private fun parseNumbers(): List<Int> {
        val numbers = mutableListOf<Int>()
        while (scanner.symbol == Symbol.IntLiteral) {
            numbers.add(scanner.text.toInt())
            matchCurrentSymbol()
        }
        return numbers
    }

    private fun parseMathOperators(): List<MathOperator> {
        val mathOperators = mutableListOf<MathOperator>()
        while (scanner.symbol in Symbol.Plus..Symbol.Times) {
            if (scanner.symbol == Symbol.Plus) {
                mathOperators.add(MathOperator.Plus)
            } else if (scanner.symbol == Symbol.Times) {
                mathOperators.add(MathOperator.Times)
            }
            matchCurrentSymbol()
        }
        return mathOperators
    }

    fun parseTransformedInput(): Transformed {
        return Transformed(parseMathProblems())
    }

    private fun parseMathProblems(): List<MathProblem> {
        val problems = mutableListOf<MathProblem>()
        while (scanner.symbol == Symbol.IntLiteral) {
            problems.add(parseMathProblem())
        }
        return problems
    }

    fun parseMathProblem(): MathProblem {
       val numbers = parseNumbers()

        val op = when (scanner.symbol) {
            Symbol.Plus -> MathOperator.Plus
            Symbol.Times -> MathOperator.Times
            else -> error("Invalid symbol: ${scanner.symbol}")
        }

        matchCurrentSymbol()

        return MathProblem(numbers, op)
    }

    private fun matchCurrentSymbol() = scanner.advance()
}
