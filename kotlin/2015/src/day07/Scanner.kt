package day07

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
            symbol = Symbol.eof
        } else if (isLetter(source.currentChar.toChar())) {
            val idString = scanIdentifier()
            symbol = getIdentifierSymbol(idString)
            if (symbol == Symbol.identifier) {
                text = idString
            }
        } else if (isDigit(source.currentChar.toChar())) {
            symbol = Symbol.intLiteral
            text = scanIntegerLiteral()
        } else {
            when (source.currentChar.toChar()) {
                '-' -> {
                    source.advance()
                    source.advance()
                    symbol = Symbol.arrow
                }

                else -> error("Invalid character: '${source.currentChar.toChar()}'")
            }
        }

        return Token(symbol, text)
    }

    private fun getIdentifierSymbol(idString: String): Symbol {
        return when (idString) {
            "NOT" -> Symbol.not
            "AND" -> Symbol.and
            "OR" -> Symbol.or
            "LSHIFT" -> Symbol.lshift
            "RSHIFT" -> Symbol.rshift
            else -> Symbol.identifier
        }
    }

    private fun skipWhiteSpace() {
        while (Character.isWhitespace(source.currentChar.toChar())) source.advance()
    }

    private fun scanIdentifier(): String {
        scanBuffer.clear()

        do {
            scanBuffer.append(source.currentChar.toChar())
            source.advance()
        } while (isLetter(source.currentChar.toChar()))

        return scanBuffer.toString()
    }

    private fun scanIntegerLiteral(): String {
        scanBuffer.clear()

        do {
            scanBuffer.append(source.currentChar.toChar())
            source.advance()
        } while (isDigit(source.currentChar.toChar()))

        return scanBuffer.toString()
    }

    private fun isLetter(ch: Char): Boolean = (ch in 'a'..'z') || (ch in 'A'..'Z')

    private fun isDigit(ch: Char): Boolean = ch in '0'..'9'
}
