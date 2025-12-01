package day01

import common.Source

class Scanner(private val source: Source) {
    var token: Token

    private val scanBuffer = StringBuilder(10)

    init {
        token = nextToken()
    }

    fun advance() {
        token = nextToken()
    }

    private fun nextToken(): Token {
        skipWhiteSpace()

        if (source.currentChar == source.eof) {
            return Token.EOF
        } else  {
            val direction = source.currentChar.toChar()
            source.advance()
            val count = scanIntegerLiteral().toInt()
            return when (direction) {
                'L' -> Token.Left(count)
                else -> Token.Right(count)
            }
        }
    }


    private fun skipWhiteSpace() {
        while (Character.isWhitespace(source.currentChar.toChar())) source.advance()
    }

    private fun scanIntegerLiteral(): String {
        scanBuffer.clear()

        do {
            scanBuffer.append(source.currentChar.toChar())
            source.advance()
        } while (isDigit(source.currentChar.toChar()))

        return scanBuffer.toString()
    }

    private fun isDigit(ch: Char): Boolean = ch in '0'..'9'
}
