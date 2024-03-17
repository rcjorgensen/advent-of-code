import java.io.File

enum class State {
    ReadingFirstDigit,
    ReadingSecondDigit,
}

fun main() {
    val input = File("input.txt").bufferedReader().use { it.readText() }

    var state: State = State.ReadingFirstDigit
    var sum: Int = 0
    var lastDigit: Char? = null

    var i = 0
    while (i < input.length) {
        val next = input[i]

        if ('0' <= next && next <= '9') {
            lastDigit = next

            if (state == State.ReadingFirstDigit) {
                state = State.ReadingSecondDigit
                sum += 10 * (next - '0')
            }
        }

        if (next == '\n') {
            sum += lastDigit!! - '0'
            state = State.ReadingFirstDigit
        }

        i++
    }

    println(sum)
}
