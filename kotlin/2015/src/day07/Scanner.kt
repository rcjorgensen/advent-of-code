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
            symbol = Symbol.EOF
        } else if (isLetter(source.currentChar.toChar())) {
            val idString = scanIdentifier()
            symbol = getIdentifierSymbol(idString)
            if (symbol == Symbol.Identifier) {
                text = if (isReserved(idString)) "${idString}_" else idString
            }
        } else if (isDigit(source.currentChar.toChar())) {
            symbol = Symbol.IntLiteral
            text = scanIntegerLiteral()
        } else {
            when (source.currentChar.toChar()) {
                '-' -> {
                    source.advance()
                    source.advance()
                    symbol = Symbol.Arrow
                }

                else -> error("Invalid character: '${source.currentChar.toChar()}'")
            }
        }

        return Token(symbol, text)
    }

    private fun getIdentifierSymbol(idString: String): Symbol {
        return when (idString) {
            "NOT" -> Symbol.Not
            "AND" -> Symbol.And
            "OR" -> Symbol.Or
            "LSHIFT" -> Symbol.LShift
            "RSHIFT" -> Symbol.RShift
            else -> Symbol.Identifier
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

    private fun isReserved(idString: String) = idString in listOf("as", "in", "do", "if", "is")
}
