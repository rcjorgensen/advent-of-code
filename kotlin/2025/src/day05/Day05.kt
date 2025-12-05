package day05

import common.Source
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

const val INPUT_FILE = "src/day05/input.txt"

fun main() {
    val file = File(INPUT_FILE)
    val fileReader = FileReader(file, Charsets.UTF_8)
    val reader = BufferedReader(fileReader)
    val source = Source(reader)
    val scanner = Scanner(source)
    val parser = Parser(scanner)
    val input = parser.parseInput()

    val part1 = input.ids.count { id -> input.ranges.any { range -> id in range } }
    println(part1)

    val nodes = input.ranges.map { Node(it) }
    for (i in 0..<nodes.size - 1) {
        val ni = nodes[i]
        for (j in i + 1..<nodes.size) {
            val nj = nodes[j]
            if (ni.overlaps(nj)) {
                ni.neighbors.add(nj)
                nj.neighbors.add(ni)
            }
        }
    }

    fun visit(node: Node, ranges: MutableList<LongRange>) {
        if (node.visited) return
        ranges.add(node.range)
        node.visited = true
        for (neighbor in node.neighbors) {
            visit(neighbor, ranges)
        }
    }

    val merged = mutableListOf<LongRange>()
    for (node in nodes) {
        val ranges = mutableListOf<LongRange>()
        visit(node, ranges)
        // ranges is empty if node has been visited i.e. is connected to a previously processed node
        if (ranges.isNotEmpty()) merged.add(merge(ranges))
    }

    var part2 = 0L
    for (range in merged) {
        part2 += range.last - range.first + 1
    }

    println(part2)
}

fun merge(ranges: List<LongRange>): LongRange = ranges.minOf { it.first }..ranges.maxOf { it.last }
