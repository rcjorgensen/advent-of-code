package day12

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day12.ast.Input
import day12.ast.Region
import day12.ast.Shape

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    fun parseInput(): Input {
        val shapes = parseShapes()
        val regions = parseRegions()
        match(Symbol.EOF)
        return Input(shapes, regions)
    }

    private fun parseRegions(): List<Region> {
        val regions = mutableListOf<Region>()
        while (scanner.symbol == Symbol.IntLiteral && scanner.lookahead(2).symbol == Symbol.Times) {
            regions.add(parseRegion())
        }
        return regions
    }

    private fun parseRegion(): Region {
        val width = scanner.token.text.toInt()
        matchCurrentSymbol()
        match(Symbol.Times)
        val length = scanner.token.text.toInt()
        matchCurrentSymbol()
        match(Symbol.Colon)
        val quantities = mutableListOf<Int>()
        while (scanner.symbol == Symbol.IntLiteral && scanner.lookahead(2).symbol != Symbol.Times) {
            quantities.add(scanner.token.text.toInt())
            matchCurrentSymbol()
        }
        return Region(width, length, quantities)
    }

    private fun parseShapes(): List<Shape> {
        val shapes = mutableListOf<Shape>()
        while (scanner.symbol == Symbol.IntLiteral && scanner.lookahead(2).symbol == Symbol.Colon) {
            shapes.add(parseShape())
        }
        return shapes
    }

    private fun parseShape(): Shape {
        match(Symbol.IntLiteral)
        match(Symbol.Colon)
        val entries = BooleanArray(9)
        for (i in 0..8) {
            entries[i] = when (scanner.symbol) {
                Symbol.Dot -> false
                Symbol.Hash -> true
                else -> error("Invalid symbol: ${scanner.symbol}")
            }
            matchCurrentSymbol()
        }
        return Shape(entries)
    }
}
