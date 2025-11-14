import java.io.File

const val ROCK = 1
const val PAPER = 2
const val SCISSORS = 3
const val LOSE = 0
const val DRAW = 3
const val WIN = 6

enum class Left { A, B, C }
enum class Right { X, Y, Z }

fun main() {
    val lines = File("2022/input/day02.txt").readLines()
    val pairs = parse(lines)

    // Part 1:
    // A: Rock  B: Paper  C: Scissors
    // X: Rock  Y: Paper  Z: Scissors
    val score1 = pairs.sumOf { (opponent, response) ->
        when (response) {
            Right.X -> ROCK + when (opponent) {
                Left.A -> DRAW
                Left.B -> LOSE
                Left.C -> WIN
            }

            Right.Y -> PAPER + when (opponent) {
                Left.A -> WIN
                Left.B -> DRAW
                Left.C -> LOSE
            }

            Right.Z -> SCISSORS + when (opponent) {
                Left.A -> LOSE
                Left.B -> WIN
                Left.C -> DRAW
            }
        }
    }

    println("Part 1: $score1")

    // Part 2:
    // A: Rock  B: Paper  C: Scissors
    // X: Lose  Y: Draw   Z: Win
    val score2 = pairs.sumOf { (opponent, response) ->
        when (response) {
            Right.X -> LOSE + when (opponent) {
                Left.A -> SCISSORS
                Left.B -> ROCK
                Left.C -> PAPER
            }

            Right.Y -> DRAW + when (opponent) {
                Left.A -> ROCK
                Left.B -> PAPER
                Left.C -> SCISSORS
            }

            Right.Z -> WIN + when (opponent) {
                Left.A -> PAPER
                Left.B -> SCISSORS
                Left.C -> ROCK
            }
        }
    }

    println("Part 2: $score2")
}

fun parse(lines: List<String>): List<Pair<Left, Right>> = lines.filter { it.isNotEmpty() }.map {
    val left = it[0]
    val right = it[2]
    val opponentMove = when (left) {
        'A' -> Left.A
        'B' -> Left.B
        'C' -> Left.C
        else -> throw IllegalArgumentException("Invalid left: $left")
    }
    val response = when (right) {
        'X' -> Right.X
        'Y' -> Right.Y
        'Z' -> Right.Z
        else -> throw IllegalArgumentException("Invalid right: $right")
    }
    opponentMove to response
}
