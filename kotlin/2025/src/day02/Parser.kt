package day02

import day02.ast.Program

class Parser(private val scanner: Scanner) {
    fun parseProgram(): Program {
        return Program(parseRanges())
    }

    private fun parseRanges(): List<LongRange> {
        val ranges = mutableListOf<LongRange>()
        while (scanner.symbol != Symbol.EOF) {
            ranges.add(parseRange())
        }
        return ranges
    }

    private fun parseRange(): LongRange {
        val start = scanner.token
        matchCurrentSymbol()
        matchCurrentSymbol()
        val end = scanner.token
        matchCurrentSymbol()
        matchCurrentSymbol()
        return start.text.toLong()..end.text.toLong()
    }

    private fun matchCurrentSymbol() = scanner.advance()
}
