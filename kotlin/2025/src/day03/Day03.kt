package day03

import common.Source
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val INPUT_FILE = "src/day03/input.txt"
const val PART = 2

fun main() {
    val file = File(INPUT_FILE)
    val fileReader = FileReader(file, Charsets.UTF_8)
    val reader = BufferedReader(fileReader)
    val source = Source(reader)
    val scanner = Scanner(source)
    val parser = Parser(scanner)
    val program = parser.parseProgram()
    var sum = 0L

    val k = when (PART) {
        1 -> 1
        2 -> 11
        else -> error("Invalid part: $PART")
    }

    for (bank in program.banks) {
        var maxIndex = -1
        val maxes = mutableListOf<Char>()
        for (n in k downTo 0) {
            var max = '0'
            maxIndex++
            for (i in maxIndex..<bank.length - n) {
                val d = bank[i]
                if (d > max) {
                    max = d
                    maxIndex = i
                }
            }
            maxes.add(max)
        }
        sum += String(maxes.toCharArray()).toLong()
    }
    println(sum)
}
