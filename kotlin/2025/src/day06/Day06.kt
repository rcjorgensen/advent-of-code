package day06

import common.Source
import common.Symbol

fun main() {
    // Part 1:
    val input1 = Parser(Scanner(Source.fromPath("src/day06/input.txt"))).parseInput()

    val columns = input1.mathOperators.size
    val results = LongArray(columns)

    for ((index, op) in input1.mathOperators.withIndex()) {
        if (op == Symbol.Times) {
            results[index] = 1
        }
    }

    for ((index, value) in input1.numbers.withIndex()) {
        val i = index % columns
        when (val op = input1.mathOperators[i]) {
            Symbol.Plus -> results[i] += value
            Symbol.Times -> results[i] *= value
            else -> error("Invalid operator: $op")
        }
    }

    println(results.sum())

    // Part 2:
    val transformed = Parser(Scanner(Source.fromPath("src/day06/input.transformed.txt"))).parseTransformedInput()

    var result = 0L
    for (problem in transformed.problems) {
        result += when (problem.mathOperator) {
            Symbol.Plus -> problem.numbers.fold(0L) { sum, element -> sum + element }
            Symbol.Times -> problem.numbers.fold(1L) { product, element -> product * element }
            else -> error("Invalid operator: ${problem.mathOperator}")
        }
    }

    println(result)
}
