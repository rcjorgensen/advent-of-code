package day03

import day03.ast.Program

class Parser(private val scanner: Scanner) {
    fun parseProgram(): Program {
        return Program(parseBanks())
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

    private fun matchCurrentSymbol() = scanner.advance()
}
