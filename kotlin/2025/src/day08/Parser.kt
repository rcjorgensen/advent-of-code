package day08

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day08.ast.Input

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    fun parseInput(): Input {
        return Input(parseTriples())
    }

    fun parseTriples(): List<Triple<Long, Long, Long>> {
        val triples = mutableListOf<Triple<Long, Long, Long>>()
        do {
            triples.add(parseTriple())
        } while (scanner.token.symbol == Symbol.IntLiteral)
        match(Symbol.EOF)
        return triples
    }

    fun parseTriple(): Triple<Long, Long, Long> {
        val first = scanner.token.text.toLong()
        matchCurrentSymbol()
        match(Symbol.Comma)
        val second = scanner.token.text.toLong()
        matchCurrentSymbol()
        match(Symbol.Comma)
        val third = scanner.token.text.toLong()
        matchCurrentSymbol()

        return Triple(first, second, third)
    }
}
