package common

class Token<TSymbol>(val symbol: TSymbol, text: String) {
    var text = text.ifEmpty { symbol.toString() }
    override fun toString() = text
}
