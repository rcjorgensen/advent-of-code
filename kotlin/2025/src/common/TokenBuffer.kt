package common

class TokenBuffer(private val capacity: Int) {
    private val buffer: Array<Token> = Array(capacity) { Token() }
    private var tokenIndex = 0   // circular index

    operator fun get(i: Int): Token = buffer[(tokenIndex + i) % capacity]

    fun add(token: Token) {
        buffer[tokenIndex] = token
        tokenIndex = (tokenIndex + 1) % capacity
    }
}
