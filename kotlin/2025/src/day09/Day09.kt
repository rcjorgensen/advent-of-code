package day09

import common.Source
import kotlin.math.max
import kotlin.math.min

//import kotlin.math.abs

fun main() {
    val input = Parser(Scanner(Source.fromPath("src/day09/input.txt"))).parseInput()
    val coordinates = input.coordinates

    val minY = coordinates.minOf { it.second }
    val maxY = coordinates.maxOf { it.second }
    val minX = coordinates.minOf { it.first }
    val maxX = coordinates.maxOf { it.first }

    val height = maxY - minY
    val width = maxX - minX

    val newCoordinates = coordinates.map { pair -> Pair(pair.first - minX, pair.second - minY) }

    val grid = Array(height) {
        val chars = CharArray(width)
        for (i in 0..<width) {
            chars[i] = '.'
        }
        chars
    }

    for (i in 0..<newCoordinates.size) {
        val (x, y) = newCoordinates[i]
        val (u, v) = newCoordinates[(i + 1) % newCoordinates.size]

        grid[y][x] = '#'
        grid[v][u] = '#'

        if (x == u) {
            val min = min(y, v)
            val max = max(y, v)
            for (j in min + 1..<max) {
                grid[j][x] = 'X'
            }
        } else {
            val min = min(x, u)
            val max = max(x, u)
            for (j in min + 1..<max) {
                grid[y][j] = 'X'
            }
        }
    }

    for (chars in grid) {
        println(chars)
    }

//    // Part 1:
//    var max = 0L
//    for (i in 0..<coordinates.size - 1) {
//        for (j in i + 1..<coordinates.size) {
//            val first = coordinates[i]
//            val second = coordinates[j]
//            val area = getArea(first, second)
//            if (area > max) {
//                max = area
//            }
//        }
//    }
//    println(max)
}

//fun getArea(corner1: Pair<Long, Long>, corner2: Pair<Long, Long>): Long {
//    val (x1, y1) = corner1
//    val (x2, y2) = corner2
//    val l1 = abs(x2 - x1) + 1
//    val l2 = abs(y2 - y1) + 1
//    return l1 * l2
//}
