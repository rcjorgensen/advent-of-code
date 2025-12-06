package day02

import common.Source

fun main() {
    val input = Parser(Scanner(Source.fromPath("src/day02/input.txt"))).parseInput()

    var sum1 = 0L
    var sum2 = 0L
    for (range in input.ranges) {
        for (number in range) {
            val digits = number.toString(10)
            if (hasPattern1(digits)) sum1 += number
            if (hasPattern2(digits)) sum2 += number
        }
    }
    println(sum1)
    println(sum2)
}

fun hasPattern1(digits: String): Boolean {
    if (digits.length % 2 != 0) {
        return false
    }
    val parts = digits.chunked(digits.length / 2)
    return parts[0] == parts[1]
}

fun hasPattern2(digits: String): Boolean {
    // pattern length can't exceed half of number length
    val maxPatternLength = digits.length / 2
    for (i in 1..maxPatternLength) {
        // pattern length must divide number length
        if (digits.length % i == 0) {
            val chunks = digits.chunked(i)
            if (chunks.all {
                    it == chunks[0]
                }) {
                return true
            }
        }
    }
    return false
}
