package common

abstract class AbstractParser(protected val scanner: AbstractScanner) {
    protected fun match(expectedSymbol: Symbol) =
        if (scanner.symbol == expectedSymbol) scanner.advance()
        else error("Expecting \"$expectedSymbol\" but found \"${scanner.token}\" instead.")

    protected fun matchCurrentSymbol() = scanner.advance()
}
