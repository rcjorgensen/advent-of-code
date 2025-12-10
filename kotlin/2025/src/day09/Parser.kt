package day09

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day09.ast.Input

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    fun parseInput(): Input {
        return Input(parseCoordinates())
    }

    fun parseCoordinates(): List<Pair<Int, Int>> {
        val coordinates = mutableListOf<Pair<Int, Int>>()
        do {
            coordinates.add(parseCoordinate())
        } while (scanner.token.symbol == Symbol.IntLiteral)
        match(Symbol.EOF)
        return coordinates
    }

    fun parseCoordinate(): Pair<Int, Int> {
        val first = scanner.token.text.toInt()
        matchCurrentSymbol()
        match(Symbol.Comma)
        val second = scanner.token.text.toInt()
        matchCurrentSymbol()

        return Pair(first, second)
    }
}
