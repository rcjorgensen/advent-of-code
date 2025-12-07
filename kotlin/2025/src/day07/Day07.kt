package day07

import java.io.File

fun main() {
    val input = File("src/day07/input.txt").readLines(Charsets.UTF_8)
    val height = input.size
    val width = input[0].length
    val startColumn = input[0].indexOf('S')

    // Part 1:
    val buffer1 = input.map { it.toCharArray() }

    val columnsWithBeams = mutableSetOf<Int>()
    val columnsToSplit = mutableSetOf<Int>()

    columnsWithBeams.add(startColumn)

    var splitCount = 0
    for (chars in buffer1.drop(1)) {
        for (column in columnsWithBeams) {
            if (chars[column] == '^') {
                splitCount++
                columnsToSplit.add(column)
            }
        }

        // Assumption: Splitters (^) always have at least one empty space (.) between them.
        for (column in columnsToSplit) {
            columnsWithBeams.remove(column)
            // Assumption: Splitters are never at the edge, so no boundary checks are needed.
            columnsWithBeams.add(column - 1)
            columnsWithBeams.add(column + 1)
        }

        columnsToSplit.clear()
    }
    println(splitCount)

    // Part 2:
    val buffer: Array<LongArray> = Array(height) { LongArray(width) }

    buffer[1][startColumn] = 1

    for (i in 2 until height) {
        for (j in 0 until width) {
            if (input[i][j] != '^') {
                buffer[i][j] = buffer[i - 1][j]
                if (j - 1 >= 0 && input[i - 1][j - 1] == '^') {
                    buffer[i][j] += buffer[i - 2][j - 1]
                }
                if (j + 1 < width && input[i - 1][j + 1] == '^') {
                    buffer[i][j] += buffer[i - 2][j + 1]
                }
            }
        }
    }

    println(buffer.last().sum())
}
