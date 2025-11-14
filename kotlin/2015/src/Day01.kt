import java.io.File

fun main() {
    val text = File("2015/input/day01.txt").readText()

    var firstBasementPos: Int? = null
    var pos = 1
    var floor = 0
    for (c in text) {
        when (c) {
            '(' -> floor++
            ')' -> floor--
        }

        if (floor < 0 && firstBasementPos == null) {
            firstBasementPos = pos
        }

        pos++
    }

    println("Part 1: $floor")
    println("Part 2: $firstBasementPos")
}
