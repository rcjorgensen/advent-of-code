package day06

const val EOF = -1

const val UNKNOWN = 0
const val TURN_ON = 1
const val TURN_OFF = 2
const val TOGGLE = 3
const val COMMA = 4
const val THROUGH = 5

fun tokenToString(token: Int?): String = when (token) {
    EOF -> "eof"
    UNKNOWN -> "unknown"
    TURN_ON -> "turn on"
    TURN_OFF -> "turn off"
    TOGGLE -> "toggle"
    COMMA -> ","
    THROUGH -> "through"
    else -> "$token"
}
