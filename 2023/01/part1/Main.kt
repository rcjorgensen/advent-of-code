enum class State {
    ReadingFirstDigit,
    ReadingLastDigit,
}

fun main() {
    var state: State = State.ReadingFirstDigit
    var sum: Int = 0
    var lastDigit: Char? = null

    val input = StringBuilder()
    while (true) {
        var line = readlnOrNull()
        if (line == null) {
            break
        }
        input.appendLine(line)
    }

    for (c in input) {
        if ('0' <= c && c <= '9') {
            lastDigit = c

            if (state == State.ReadingFirstDigit) {
                state = State.ReadingLastDigit
                sum += 10 * (c - '0')
            }
        }

        if (c == '\n') {
            sum += lastDigit!! - '0'
            state = State.ReadingFirstDigit
        }
    }

    sum += lastDigit!! - '0'
    println(sum)
}
