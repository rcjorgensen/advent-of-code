package day04

import java.io.File
import java.security.MessageDigest

fun main() {
    val text = File("src/day04/input.txt").readText()
    val md = MessageDigest.getInstance("MD5")

    var i = 1
    while (true) {
        val digest = md.digest("$text$i".toByteArray())
        val hex = digest.toHexString()
        if (hex.startsWith("00000")) {
            println("Part 1: $i")
            break
        }
        i++
    }

    while (true) {
        val digest = md.digest("$text$i".toByteArray())
        val hex = digest.toHexString()
        if (hex.startsWith("000000")) {
            println("Part 2: $i")
            break
        }
        i++
    }
}
