import java.io.File

fun main() {
    val lines = File("2015/input/day05.txt").readLines()
    val nice = lines.count { isNice(it) }
    println("Part 1: $nice")
    val nice2 = lines.count { isNice2(it) }
    println("Part 2: $nice2")
}

fun isNice(line: String): Boolean {
    val vowels = "aeiou"
    var vs = 0
    var ds = 0
    for (i in 0..<line.length) {
        val a = line[i]
        if (vowels.contains(a)) {
            vs++
        }
        if (i + 1 < line.length) {
            val b = line[i + 1]
            if (a == 'a' && b == 'b' || a == 'c' && b == 'd' || a == 'p' && b == 'q' || a == 'x' && b == 'y') {
                return false
            }
            if (a == b) {
                ds++
            }
        }
    }
    return vs >= 3 && ds >= 1
}

fun isNice2(line: String): Boolean {
    var foundRepeat = false
    var foundPair = false
    for (i in 0..<line.length) {
        if (!foundRepeat && i + 2 < line.length && line[i] == line[i + 2]) {
            foundRepeat = true
        }
        if (!foundPair && i + 1 < line.length && hasPair(line.substring(i + 2), line[i], line[i + 1])) {
            foundPair = true
        }
        if (foundRepeat && foundPair) {
            return true
        }
    }

    return false
}

fun hasPair(str: String, a: Char, b: Char): Boolean {
    for (i in 0..<str.length - 1) {
        if (str[i] == a && str[i + 1] == b) {
            return true
        }
    }
    return false
}
