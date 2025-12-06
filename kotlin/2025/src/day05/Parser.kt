package day05

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day05.ast.Input

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    fun parseInput(): Input {
        val ranges = parseRanges()
        val ids = parseIds()
        return Input(ranges, ids)
    }

    private fun parseRanges(): List<LongRange> {
        val ranges = mutableListOf<LongRange>()
        while (scanner.lookahead(2).symbol == Symbol.Hyphen) {
            ranges.add(parseRange())
        }
        return ranges
    }

    private fun parseRange(): LongRange {
        val start = scanner.text.toLong()
        matchCurrentSymbol()
        matchCurrentSymbol()
        val end = scanner.text.toLong()
        matchCurrentSymbol()
        return start..end
    }

    private fun parseIds(): List<Long> {
        val ids = mutableListOf<Long>()
        while (scanner.symbol != Symbol.EOF) {
            ids.add(parseId())
        }
        return ids
    }

    private fun parseId(): Long {
        val id = scanner.text.toLong()
        matchCurrentSymbol()
        return id
    }
}
