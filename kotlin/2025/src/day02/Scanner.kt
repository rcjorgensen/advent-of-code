package day02

import common.Source

class Scanner(private val source: Source) {
    var token: Token
    val symbol: Symbol
        get() = token.symbol

    private val scanBuffer = StringBuilder(10)

    init {
        token = nextToken()
    }

    fun advance() {
        token = nextToken()
    }

    private fun nextToken(): Token {
        var symbol: Symbol
        var text = ""

        skipWhiteSpace()

        if (source.currentChar == source.eof) {
            symbol = Symbol.EOF
        } else if (isDigit(source.currentChar.toChar()))  {
            symbol = Symbol.IntLiteral
            text = scanIntegerLiteral()
        } else {
            symbol = when (source.currentChar.toChar()) {
                '-' -> {
                    Symbol.Hyphen
                }

                ',' -> {
                    Symbol.Comma
                }

                else -> error("Invalid character: '${source.currentChar.toChar()}'")
            }
            source.advance()
        }

        return Token(symbol, text)
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
