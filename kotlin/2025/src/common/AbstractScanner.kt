package common

abstract class AbstractScanner(protected val source: Source, k: Int) {
    private val tokenBuffer = TokenBuffer(k)
    private val scanBuffer = StringBuilder()

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

    protected abstract fun nextToken(): Token

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
