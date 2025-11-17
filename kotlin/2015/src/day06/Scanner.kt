package day06

import common.Source

class Scanner(private val source: Source) {
    var token: Int = UNKNOWN
    private val scanBuffer = StringBuilder(10)

    init {
        advance()   // Set first token
    }

    fun advance() {
        token = nextToken()
    }

    private fun nextToken(): Int {
        var token: Int
        skipWhiteSpace()

        if (source.currentChar == source.eof) {
            // set token but don't advance source
            token = EOF
        } else if (isLetter(source.currentChar.toChar())) {
            scanBuffer.clear()
            do {
                scanBuffer.append(source.currentChar.toChar())
                source.advance()
            } while (isLetter(source.currentChar.toChar()))

            token = when (val word = scanBuffer.toString()) {
                "turn" -> {
                    scanBuffer.clear()
                    source.advance()
                    do {
                        scanBuffer.append(source.currentChar.toChar())
                        source.advance()
                    } while (isLetter(source.currentChar.toChar()))
                    if (scanBuffer.toString() == "on") TURN_ON else TURN_OFF
                }

                "toggle" -> TOGGLE
                "through" -> THROUGH
                else -> error("Unexpected word: $word")
            }
        } else if (isDigit(source.currentChar.toChar())) {
            token = scanInteger()
        } else {
            when (source.currentChar.toChar()) {
                ',' -> {
                    token = COMMA
                    source.advance()
                }

                else -> error("Invalid character: '${source.currentChar.toChar()}'")
            }
        }

        return token
    }

    private fun skipWhiteSpace() {
        while (Character.isWhitespace(source.currentChar.toChar())) source.advance()
    }

    private fun scanInteger(): Int {
        scanBuffer.clear()

        do {
            scanBuffer.append(source.currentChar.toChar())
            source.advance()
        } while (isDigit(source.currentChar.toChar()))

        return scanBuffer.toString().toInt()
    }

    private fun isLetter(ch: Char): Boolean = (ch in 'a'..'z') || (ch in 'A'..'Z')

    private fun isDigit(ch: Char): Boolean = ch in '0'..'9'
}
