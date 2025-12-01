package day01

import common.Source
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val INPUT_FILE = "src/day01/input.txt"

fun main() {
    val file = File(INPUT_FILE)
    val fileReader = FileReader(file, Charsets.UTF_8)
    val reader = BufferedReader(fileReader)
    val source = Source(reader)
    val scanner = Scanner(source)
    val tokens = mutableListOf<Token>()
    do {
        tokens.add(scanner.token)
        scanner.advance()
    } while (scanner.token != Token.EOF)

    var count1 = 0
    var count2 = 0
    var pos = 50

    for (token in tokens) {
        when (token) {
            is Token.Right ->  {
                repeat(token.count) {
                    pos++
                    if (pos == 100) {
                        pos = 0
                        count2++
                    }
                }
            }
            is Token.Left -> {
                repeat(token.count) {
                    pos--
                    if (pos == 0) {
                        count2++
                    }
                    if (pos == -1) {
                        pos = 99
                    }
                }
            }
            else -> error("Invalid token: $token")
        }

        println(pos)

        if (pos == 0) {
            count1++
        }
    }

    println("Part 1: $count1")
    println("Part 2: $count2")
}
