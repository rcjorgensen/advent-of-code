package day06

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day06.ast.Input
import day06.ast.MathProblem
import day06.ast.Transformed

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
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

    private fun parseMathOperators(): List<Symbol> {
        val mathOperators = mutableListOf<Symbol>()
        while (scanner.symbol in Symbol.Plus..Symbol.Times) {
            mathOperators.add(scanner.symbol)
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
        val mathOperator = scanner.symbol

        matchCurrentSymbol()

        return MathProblem(numbers, mathOperator)
    }
}
