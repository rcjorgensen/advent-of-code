package day02

import common.Source
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val INPUT_FILE = "src/day02/input.txt"

fun main() {
    val file = File(INPUT_FILE)
    val fileReader = FileReader(file, Charsets.UTF_8)
    val reader = BufferedReader(fileReader)
    val source = Source(reader)
    val scanner = Scanner(source)
    val parser = Parser(scanner)
    val program = parser.parseProgram()

    var sum = 0L
    for (range in program.ranges) {
        for (number in range) {
            val digits = number.toString(10)
//            if (hasPattern(digits)) {
//                sum += number
//            }
            if (hasPattern(digits)) {
                sum += number
            }
        }
    }
    println(sum)
}

//fun hasPattern(digits: String): Boolean {
//    if (digits.length % 2 != 0) {
//        return false
//    }
//    val parts = digits.chunked(digits.length / 2)
//    return parts[0] == parts[1]
//}

fun hasPattern(digits: String): Boolean {
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
