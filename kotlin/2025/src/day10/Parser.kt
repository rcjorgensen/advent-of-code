package day10

import common.AbstractParser
import common.AbstractScanner
import common.Symbol
import day10.ast.Button
import day10.ast.IndicatorLightDiagram
import day10.ast.Machine

class Parser(scanner: AbstractScanner) : AbstractParser(scanner) {
    fun parseMachines(): List<Machine> {
        val machines = mutableListOf<Machine>()
        while (scanner.symbol == Symbol.LeftBracket) {
            machines.add(parseMachine())
        }
        match(Symbol.EOF)
        return machines
    }

    private fun parseMachine(): Machine {
        val indicatorLightDiagram = parseIndicatorLightDiagram()
        val buttons = parseButtons()
        val joltageRequirements = parseJoltageRequirements()
        return Machine(indicatorLightDiagram, joltageRequirements, buttons)
    }

    private fun parseIndicatorLightDiagram(): IndicatorLightDiagram {
        match(Symbol.LeftBracket)
        var lights = 0U
        var i = 0
        while (scanner.symbol in Symbol.Dot..Symbol.Hash) {
            if (scanner.symbol == Symbol.Hash) {
                lights = lights or (1U shl i)
            }
            matchCurrentSymbol()
            i++
        }
        match(Symbol.RightBracket)
        return IndicatorLightDiagram(lights, i)
    }

    private fun parseButtons(): List<Button> {
        val buttons = mutableListOf<Button>()
        while (scanner.symbol == Symbol.LeftParen) {
            buttons.add(parseButton())
        }
        return buttons
    }

    private fun parseButton(): Button {
        val lightPositions = mutableListOf<Int>()
        match(Symbol.LeftParen)
        lightPositions.add(
            scanner.token.text.toInt()
        )
        matchCurrentSymbol()
        while (scanner.symbol == Symbol.Comma) {
            matchCurrentSymbol()
            lightPositions.add(
                scanner.token.text.toInt()
            )
            matchCurrentSymbol()
        }
        match(Symbol.RightParen)
        return Button(lightPositions)
    }

    private fun parseJoltageRequirements(): IntArray {
        val joltages = mutableListOf<Int>()
        match(Symbol.LeftBrace)
        joltages.add(
            scanner.token.text.toInt()
        )
        matchCurrentSymbol()
        while (scanner.symbol == Symbol.Comma) {
            matchCurrentSymbol()
            joltages.add(
                scanner.token.text.toInt()
            )
            matchCurrentSymbol()
        }
        match(Symbol.RightBrace)
        return joltages.toIntArray()
    }
}
