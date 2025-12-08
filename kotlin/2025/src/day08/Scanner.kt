package day08

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
        } else if (source.currentChar.toChar() == ',') {
            symbol = Symbol.Comma
            source.advance()
        } else {
            error("Invalid character: '${source.currentChar.toChar()}'")
        }

        return Token(symbol, text)
    }
}
