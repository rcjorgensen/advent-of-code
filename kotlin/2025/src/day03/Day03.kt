package day03

import common.Source

fun main() {
    val input = Parser(Scanner(Source.fromPath("src/day03/input.txt"))).parseInput()

    var sum1 = 0L
    var sum2 = 0L

    for (bank in input.banks) {
        var maxIndex = -1
        val maxes = mutableListOf<Char>()
        for (n in 1 downTo 0) {
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
        sum1 += String(maxes.toCharArray()).toLong()
    }

    for (bank in input.banks) {
        var maxIndex = -1
        val maxes = mutableListOf<Char>()
        for (n in 11 downTo 0) {
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
        sum2 += String(maxes.toCharArray()).toLong()
    }

    println(sum1)
    println(sum2)
}
