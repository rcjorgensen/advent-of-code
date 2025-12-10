package day10

import common.Source
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

fun main() {
    val machines = Parser(Scanner(Source.fromPath("src/day10/input.txt"))).parseMachines()
    for ((i, machine) in machines.withIndex()) {
        machine.out = PrintWriter(FileWriter(File("src/day10/lp/machine$i.lp"), Charsets.UTF_8), true)
        machine.emit()
    }
}
