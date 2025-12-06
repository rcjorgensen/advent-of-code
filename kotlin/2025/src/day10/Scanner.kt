package day10

import common.AbstractScanner
import common.Source
import common.Symbol
import common.Token

class Scanner(source: Source) : AbstractScanner(source, TODO("Set k")) {
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
            TODO("Implement scanner")
            source.advance()
        }

        return Token(symbol, text)
    }
}
