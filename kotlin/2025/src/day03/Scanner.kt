package day03

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
        } else {
            symbol = Symbol.IntLiteral
            text = scanIntegerLiteral()
        }

        return Token(symbol, text)
    }
}
