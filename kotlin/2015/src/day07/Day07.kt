package day07

import common.Source
import day07.ast.AST
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.PrintWriter

const val INPUT_FILE = "src/day07/input.txt"
const val OUTPUT_FILE = "src/day07/Input.kt"

fun main() {
    val targetFile = File(OUTPUT_FILE)
    val fileWriter = FileWriter(targetFile, Charsets.UTF_8)

    val file = File(INPUT_FILE)
    val fileReader = FileReader(file, Charsets.UTF_8)
    val reader = BufferedReader(fileReader)
    val source = Source(reader)
    val scanner = Scanner(source)
    val parser = Parser(scanner)

    val input = parser.parseInput()

    AST.out = PrintWriter(fileWriter, true)
    input.emit()
}
