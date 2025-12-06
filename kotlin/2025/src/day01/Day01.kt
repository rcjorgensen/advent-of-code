package day01

import common.Source
import common.Symbol

fun main() {
    val input = Parser(Scanner(Source.fromPath("src/day01/input.txt"))).parseInput()

    var count1 = 0
    var count2 = 0
    var pos = 50

    for (rotation in input.rotations) {
        when (rotation.direction) {
            Symbol.Right -> {
                repeat(rotation.distance) {
                    pos++
                    if (pos == 100) {
                        pos = 0
                        count2++
                    }
                }
            }

            Symbol.Left -> {
                repeat(rotation.distance) {
                    pos--
                    if (pos == 0) {
                        count2++
                    }
                    if (pos == -1) {
                        pos = 99
                    }
                }
            }

            else -> error("Invalid direction: ${rotation.direction}")
        }

        if (pos == 0) {
            count1++
        }
    }

    println("Part 1: $count1")
    println("Part 2: $count2")
}
