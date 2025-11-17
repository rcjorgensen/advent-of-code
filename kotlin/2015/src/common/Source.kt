package common

import java.io.Reader

class Source(private val reader: Reader) {
    val eof = -1
    var currentChar = 0
        private set

    init {
        advance()
    }

    fun advance() {
        currentChar = reader.read()
    }
}
