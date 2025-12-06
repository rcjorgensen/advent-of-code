package day02

import common.AbstractParser
import common.Symbol
import day02.ast.Input

class Parser(scanner: Scanner) : AbstractParser(scanner) {
    fun parseInput(): Input {
        return Input(parseRanges())
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
}
