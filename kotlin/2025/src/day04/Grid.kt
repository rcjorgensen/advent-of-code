package day04

class Grid(private val width: Int, private val height: Int, private val data: MutableList<Char>) {
    private fun index(x: Int, y: Int): Int = y * width + x
    private fun neighbors(x: Int, y: Int): Int {
        var count = 0
        if (isPaperRoll(x - 1, y - 1)) count++
        if (isPaperRoll(x, y - 1)) count++
        if (isPaperRoll(x + 1, y - 1)) count++

        if (isPaperRoll(x - 1, y)) count++
        if (isPaperRoll(x + 1, y)) count++

        if (isPaperRoll(x - 1, y + 1)) count++
        if (isPaperRoll(x, y + 1)) count++
        if (isPaperRoll(x + 1, y + 1)) count++

        return count
    }

    private fun isPaperRoll(x: Int, y: Int): Boolean {
        return x in 0..<width && y in 0..<height && data[index(x, y)] == '@'
    }

    fun canBeAccessed(): Int {
        var count = 0
        for (y in 0..<height) {
            for (x in 0..<width) {
                if (isPaperRoll(x, y) && neighbors(x, y) < 4) {
                    count++
                }
            }
        }
        return count
    }

    fun remove(): Int {
        var count = 0
        for (y in 0..<height) {
            for (x in 0..<width) {
                if (isPaperRoll(x, y) && neighbors(x, y) < 4) {
                    data[index(x, y)] = 'x'
                    count++
                }
            }
        }
        return count
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (y in 0..<height) {
            for (x in 0..<width) {
                sb.append(data[index(x, y)])
            }
            sb.append('\n')
        }
        return sb.toString()
    }
}
