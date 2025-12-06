package common

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.Reader

class Source(private val reader: Reader) {
    companion object {
        fun fromPath(pathname: String): Source {
            val file = File(pathname)
            val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
            return Source(reader)
        }
    }

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
