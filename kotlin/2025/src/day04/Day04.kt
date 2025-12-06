package day04

import java.io.File

const val INPUT_FILE = "src/day04/input.txt"

fun main() {
    val width = 135
    val height = 135
    val input = File(INPUT_FILE).readText(Charsets.UTF_8).replace("\n", "")
    val grid = Grid(width, height, input.toMutableList())

    println(grid.canBeAccessed())

    var totalRemoved = 0
    var lastRemoved: Int
    do {
        lastRemoved = grid.remove()
        totalRemoved += lastRemoved
    } while (lastRemoved > 0)
    println(totalRemoved)
}
