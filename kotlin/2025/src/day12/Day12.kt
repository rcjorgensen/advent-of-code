package day12

import common.Source

fun main() {
    val input = Parser(Scanner(Source.fromPath("src/day12/input.txt"))).parseInput()
    var candidateCount = 0
    for (region in input.regions) {
        val maxVolume = region.width * region.length
        var totalVolume = 0
        for ((j, quantity) in region.quantities.withIndex()) {
            val shape = input.shapes[j]
            totalVolume += shape.volume * quantity
        }
        if (totalVolume <= maxVolume) {
            candidateCount++
        }
    }
    println("Number of candidates: $candidateCount")
}
