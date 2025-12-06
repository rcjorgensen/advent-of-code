package day03

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day03.ast.Input

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    fun parseInput(): Input {
        return Input(parseBanks())
    }

    private fun parseBanks(): List<String> {
        val banks = mutableListOf<String>()
        while (scanner.symbol != Symbol.EOF) {
            banks.add(parseBank())
        }
        return banks
    }

    private fun parseBank(): String {
        val bank = scanner.token.text
        matchCurrentSymbol()
        return bank
    }
}
