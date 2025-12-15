package day12.ast

class Shape(val entries: BooleanArray) {
    val width = 3
    val length = 3

    override fun toString(): String {
        val buffer = StringBuilder(12)
        for (j in 0..<length) {
            for (i in 0..<width) {
                buffer.append(if (entries[index(i, j)]) '#' else '.')
            }
            buffer.append('\n')
        }
        return buffer.toString()
    }

    private fun index(i: Int, j: Int): Int = j * width + i

    val volume: Int
        get() = entries.count { it }
}
