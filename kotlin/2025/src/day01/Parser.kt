package day01

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day01.ast.Input
import day01.ast.Rotation

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    fun parseInput(): Input {
        val rotations = mutableListOf<Rotation>()
        while (scanner.symbol != Symbol.EOF) {
            rotations.add(parseRotation())
        }
        return Input(rotations)
    }

    fun parseRotation(): Rotation {
        val direction = scanner.symbol
        matchCurrentSymbol()
        val distance = scanner.text.toInt()
        matchCurrentSymbol()
        return Rotation(direction, distance)
    }
}
