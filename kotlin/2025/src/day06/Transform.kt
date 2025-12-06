package day06

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

fun main() {
    val inputFile  = "src/day06/input.txt"
    val outputFile = "src/day06/input.transformed.txt"

    val fileWriter = FileWriter(outputFile, Charsets.UTF_8)
    val out = PrintWriter(fileWriter, true)

    val file = File(inputFile)
    val lines = file.readLines()
    val columns = lines.maxOf { it.length }

    for (i in columns - 1 downTo 0) {
        for (line in lines) {
            if (i < line.length) {
                out.print(line[i])
            }
        }
        out.println()
    }
}
