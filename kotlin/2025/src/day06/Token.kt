package day06

class Token(val symbol: Symbol, text: String) {
    var text = text.ifEmpty { symbol.toString() }
    override fun toString() = text

    constructor() : this(Symbol.Unknown, "")
}
