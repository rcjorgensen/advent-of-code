package day07

class Token(val symbol: Symbol, text: String) {
    var text = text.ifEmpty { symbol.toString() }
    override fun toString() = text
}
