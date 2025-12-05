package day05

import common.Source

class Scanner(private val source: Source) {
    private val k = 2
    private val tokenBuffer = TokenBuffer(k)
    private val scanBuffer = StringBuilder(100)

    val token: Token
        get() = lookahead(1)

    val symbol: Symbol
        get() = lookahead(1).symbol

    val text: String
        get() = lookahead(1).text


    init {
        repeat(k) { advance() }
    }

    fun lookahead(i: Int): Token {
        return tokenBuffer[i - 1]
    }

    fun advance() = tokenBuffer.add(nextToken())

    private fun nextToken(): Token {
        var symbol: Symbol
        var text = ""

        skipWhiteSpace()

        if (source.currentChar == source.eof) {
            symbol = Symbol.EOF
        } else if (isDigit(source.currentChar.toChar())) {
            symbol = Symbol.IntLiteral
            text = scanIntegerLiteral()
        } else {
            symbol = when (source.currentChar.toChar()) {
                '-' -> Symbol.Hyphen
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
