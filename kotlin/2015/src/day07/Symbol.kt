package day07

enum class Symbol {
    not,
    and,
    or,
    lshift,
    rshift,
    eof,
    unknown,
    arrow,
    intLiteral,
    identifier;

    fun isReservedWord() = this in not..rshift
}
