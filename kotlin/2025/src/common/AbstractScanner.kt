package common

abstract class AbstractScanner<TSymbol>(protected val source: Source) {
    var token: Token<TSymbol>
    val symbol: TSymbol
        get() = token.symbol

    private val scanBuffer = StringBuilder()

    init {
        token = nextToken()
    }

    fun advance() {
        token = nextToken()
    }

    abstract fun nextToken(): Token<TSymbol>

    protected fun skipWhiteSpace() {
        while (Character.isWhitespace(source.currentChar.toChar())) source.advance()
    }

    protected fun scanIntegerLiteral(): String {
        scanBuffer.clear()

        do {
            scanBuffer.append(source.currentChar.toChar())
            source.advance()
        } while (isDigit(source.currentChar.toChar()))

        return scanBuffer.toString()
    }

    protected fun isDigit(ch: Char): Boolean = ch in '0'..'9'
}
