package day11

import common.AbstractScanner
import common.Source
import common.Symbol
import common.Token

class Scanner(source: Source) : AbstractScanner(source, 2) {
    override fun nextToken(): Token {
        var symbol: Symbol
        var text = ""

        skipWhiteSpace()

        if (source.currentChar == source.eof) {
            symbol = Symbol.EOF
        } else if (isLetter(source.currentChar.toChar())) {
            symbol = Symbol.Identifier
            text = scanIdentifier()
        } else {
            symbol = when (source.currentChar.toChar()) {
                ':' -> {
                    Symbol.Colon
                }

                else -> error("Invalid character '${source.currentChar.toChar()}'")
            }
            source.advance()
        }

        return Token(symbol, text)
    }
}
