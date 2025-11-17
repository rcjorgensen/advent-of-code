package day06

class Parser(private val scanner: Scanner) {
    fun parseInstructions(): List<Instruction> {
        val instructions = mutableListOf<Instruction>()
        while (scanner.token != EOF) {
            instructions.add(parseInstruction())
        }
        return instructions.toList()
    }

    private fun parseInstruction(): Instruction {
        val action = when (scanner.token) {
            TURN_ON -> Action.TurnOn
            TURN_OFF -> Action.TurnOff
            TOGGLE -> Action.Toggle
            else -> error("Invalid token: ${tokenToString(scanner.token)}")
        }
        matchCurrentToken()
        val x = scanner.token
        matchCurrentToken()
        match(COMMA)
        val y = scanner.token
        matchCurrentToken()
        match(THROUGH)
        val u = scanner.token
        matchCurrentToken()
        match(COMMA)
        val v = scanner.token
        matchCurrentToken()

        return Instruction(action, x, y, u, v)
    }

    private fun match(expectedToken: Int) {
        if (scanner.token == expectedToken) {
            scanner.advance()
        } else {
            error("Expecting ${tokenToString(expectedToken)} but found ${tokenToString(scanner.token)} instead.")
        }
    }

    private fun matchCurrentToken() = scanner.advance()
}
