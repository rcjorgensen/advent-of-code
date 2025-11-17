package day02

import java.io.Reader

class Parser(private val reader: Reader) {
    val eof = -1
    var currentChar = 0
        private set

    private val parseBuffer = StringBuilder(10)

    private fun advance() {
        currentChar = reader.read()
    }

    init {
        advance()   // advance to the first character
    }

    fun parseTriples(): List<Triple<Int, Int, Int>> {
        val triples = mutableListOf<Triple<Int, Int, Int>>()

        while (currentChar != eof) {
            triples.add(parseTriple())
            skipWhitespace()
        }

        return triples.toList()
    }

    fun parseTriple(): Triple<Int, Int, Int> {
        val l = parseInt()
        match()
        val w = parseInt()
        match()
        val h = parseInt()
        return Triple(l, w, h)
    }

    private fun parseInt(): Int {
        parseBuffer.clear()

        do {
            parseBuffer.append(currentChar.toChar())
            advance()
        } while (isDigit(currentChar.toChar()))

        return parseBuffer.toString().toInt()
    }

    private fun match() = if (currentChar.toChar() == 'x') advance()
    else error("Expecting \'x\' but found \'${currentChar.toChar()}\' instead.")

    private fun skipWhitespace() {
        while (Character.isWhitespace(currentChar.toChar())) advance()
    }

    private fun isDigit(ch: Char): Boolean = ch in '0'..'9'
}
