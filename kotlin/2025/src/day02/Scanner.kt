package day02

import common.AbstractScanner
import common.Source
import common.Symbol
import common.Token

class Scanner(source: Source) : AbstractScanner(source, 1) {
    override fun nextToken(): Token {
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
}
