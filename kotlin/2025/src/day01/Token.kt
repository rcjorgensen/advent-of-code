package day01

sealed class Token {
    data class Left(val count: Int) : Token()
    data class Right(val count: Int) : Token()
    data object EOF : Token()
}
