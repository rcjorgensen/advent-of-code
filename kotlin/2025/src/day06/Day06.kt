package day06

import common.Source
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val INPUT_FILE = "src/day06/input.transformed.txt"

fun main() {
    val file = File(INPUT_FILE)
    val fileReader = FileReader(file, Charsets.UTF_8)
    val reader = BufferedReader(fileReader)
    val source = Source(reader)
    val scanner = Scanner(source)
    val parser = Parser(scanner)

    // Part 1:
    val input = parser.parseInput()

    val columns = input.mathOperators.size
    val results = LongArray(columns)

    for ((index, op) in input.mathOperators.withIndex()) {
        if (op == MathOperator.Times) {
            results[index] = 1
        }
    }

    for ((index, value) in input.numbers.withIndex()) {
        val i = index % columns
        val op = input.mathOperators[i]
        when (op) {
            MathOperator.Plus -> results[i] += value
            MathOperator.Times -> results[i] *= value
        }
    }

    println(results.sum())

    // Part 2:
    val transformed = parser.parseTransformedInput()

    var result = 0L
    for (problem in transformed.problems) {
        result +=
            if (problem.mathOperator == MathOperator.Plus) problem.numbers.fold(0L) { sum, element -> sum + element}
            else problem.numbers.fold(1L) { product, element -> product * element }
    }

    println(result)
}
