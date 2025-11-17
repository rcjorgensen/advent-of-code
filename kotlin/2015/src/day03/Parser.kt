package day03

import java.io.Reader

class Parser(private val reader: Reader) {
    var currentChar = 0
        private set

    private fun advance() {
        currentChar = reader.read()
    }

    init {
        advance()   // advance to the first character
    }

    fun parseDirections(): List<Direction> {
        val directions = mutableListOf<Direction>()

        while (isDirection(currentChar.toChar())) {
            directions.add(parseDirection())
        }

        return directions.toList()
    }

    private fun parseDirection(): Direction {
        val direction = when (currentChar.toChar()) {
            '^' -> Direction.North
            'v' -> Direction.South
            '>' -> Direction.East
            '<' -> Direction.West
            else -> error("Invalid direction: '${currentChar.toChar()}'.")
        }
        advance()
        return direction
    }

    private fun isDirection(ch: Char): Boolean = ch in listOf('^', 'v', '>', '<')
}
