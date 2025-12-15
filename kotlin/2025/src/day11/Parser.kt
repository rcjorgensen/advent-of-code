package day11

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day11.ast.Device
import day11.ast.Input

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    val deviceTable = mutableMapOf<String, Device>()

    fun parseInput(): Input {
        val devices = mutableListOf<Device>()
        while (scanner.symbol == Symbol.Identifier) {
            devices.add(parseDevice())
        }
        match(Symbol.EOF)
        return Input(devices)
    }

    private fun parseDevice(): Device {
        val sourceId = scanner.token.text
        val source = deviceTable.getOrPut(sourceId) {
            Device(sourceId)
        }
        matchCurrentSymbol()
        match(Symbol.Colon)
        do {
            val targetId = scanner.token.text
            val target = deviceTable.getOrPut(targetId) {
                Device(targetId)
            }
            source.targets.add(target)
            matchCurrentSymbol()
        } while (scanner.symbol == Symbol.Identifier && scanner.lookahead(2).symbol != Symbol.Colon)
        return source
    }
}
