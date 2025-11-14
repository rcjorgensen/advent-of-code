import java.io.File
import java.io.StringReader

fun main() {
    val text = File("2015/input/day02.txt").readText()
    val parser = Parser(StringReader(text))
    val triples = parser.parseTriples()

    val wrappingPaper = triples.sumOf { (l, w, h) ->
        val a1 = l * w
        val a2 = w * h
        val a3 = h * l
        2 * (a1 + a2 + a3) + listOf(a1, a2, a3).min()
    }

    println("Part 1: $wrappingPaper")

    val ribbon = triples.sumOf { (l, w, h) ->
        val (a1, a2) = listOf(l, w, h).sorted()
        2 * a1 + 2 * a2 + l * w * h
    }

    println("Part 2: $ribbon")
}
