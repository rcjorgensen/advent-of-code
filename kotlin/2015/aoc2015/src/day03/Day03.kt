package day03

import java.io.File
import java.io.StringReader

fun main() {
    val text = File("src/day03/input.txt").readText()
    val parser = Parser(StringReader(text))
    val directions = parser.parseDirections()

    val part1Houses = part1(directions)

    println("Part 1: $part1Houses")

    val part2Houses = part2(directions)

    println("Part 2: $part2Houses")
}

fun part1(directions: List<Direction>): Int {
    val visited = mutableMapOf(Pair(0, mutableListOf(0)))
    var houses = 1
    var currentX = 0
    var currentY = 0

    for (direction in directions) {
        when (direction) {
            Direction.North -> currentY++
            Direction.South -> currentY--
            Direction.East -> currentX++
            Direction.West -> currentX--
        }

        val ys = visited[currentX]
        if (ys == null) {
            visited[currentX] = mutableListOf(currentY)
            houses++
        } else if (!ys.contains(currentY)) {
            ys.add(currentY)
            houses++
        }
    }

    return houses
}

fun part2(directions: List<Direction>): Int {
    val visited = mutableMapOf(Pair(0, mutableListOf(0)))
    var houses = 1
    var santaCurrentX = 0
    var santaCurrentY = 0
    var roboSantaCurrentX = 0
    var roboSantaCurrentY = 0

    var turn = 0

    for (direction in directions) {
        if (turn == 0) {
            when (direction) {
                Direction.North -> santaCurrentY++
                Direction.South -> santaCurrentY--
                Direction.East -> santaCurrentX++
                Direction.West -> santaCurrentX--
            }

            val ys = visited[santaCurrentX]
            if (ys == null) {
                visited[santaCurrentX] = mutableListOf(santaCurrentY)
                houses++
            } else if (!ys.contains(santaCurrentY)) {
                ys.add(santaCurrentY)
                houses++
            }

            turn = 1
        } else {
            when (direction) {
                Direction.North -> roboSantaCurrentY++
                Direction.South -> roboSantaCurrentY--
                Direction.East -> roboSantaCurrentX++
                Direction.West -> roboSantaCurrentX--
            }

            val ys = visited[roboSantaCurrentX]
            if (ys == null) {
                visited[roboSantaCurrentX] = mutableListOf(roboSantaCurrentY)
                houses++
            } else if (!ys.contains(roboSantaCurrentY)) {
                ys.add(roboSantaCurrentY)
                houses++
            }

            turn = 0
        }
    }

    return houses
}
