package day06

import common.Source
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val INPUT_FILE = "src/day06/input.txt"

fun main() {
    val file = File(INPUT_FILE)
    val fileReader = FileReader(file, Charsets.UTF_8)
    val reader = BufferedReader(fileReader)
    val source = Source(reader)
    val scanner = Scanner(source)
    val parser = Parser(scanner)

    val instructions = parser.parseInstructions()
    val lighting1 = Lighting()

    for ((action, x, y, u, v) in instructions) {
        when (action) {
            Action.TurnOn -> lighting1.turnOn(x, y, u, v)
            Action.TurnOff -> lighting1.turnOff(x, y, u, v)
            Action.Toggle -> lighting1.toggle(x, y, u, v)
        }
    }

    println("Part 1: ${lighting1.sum()}")

    val lighting2 = Lighting()

    for ((action, x, y, u, v) in instructions) {
        when (action) {
            Action.TurnOn -> lighting2.inc(x, y, u, v)
            Action.TurnOff -> lighting2.dec(x, y, u, v)
            Action.Toggle -> lighting2.inc(x, y, u, v, 2)
        }
    }

    println("Part 2: ${lighting2.sum()}")
}
