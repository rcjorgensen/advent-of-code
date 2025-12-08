package day08

import common.Source

fun main() {
    val input = Parser(Scanner(Source.fromPath("src/day08/input.txt"))).parseInput()
    val nodes = input.triples.map { Node(it) }

    val pairs = mutableListOf<Pair<Node, Node>>()
    val distances = mutableMapOf<Pair<Node, Node>, Long>()

    for (i in 0 until nodes.size - 1) {
        for (j in i + 1 until nodes.size) {
            val first = nodes[i]
            val second = nodes[j]
            val pair = Pair(first, second)
            pairs.add(pair)
            distances[pair] = distanceSquared(first.triple, second.triple)
        }
    }

    pairs.sortWith(compareBy { distances[it] })

//    // Part 1:
//    pairs = pairs.take(1000).toMutableList()

    // Part 2:
    var lastConnected = pairs[0]

    for (pair in pairs) {
        val (first, second) = pair
        if (!connected(first, second)) {
            first.neighbors.add(second)
            second.neighbors.add(first)

            // Part 2:
            lastConnected = pair
        }
    }

//    // Part 1:
//    val circuitSizes = mutableListOf<Long>()
//    for (node in nodes) {
//        if (!node.visited) {
//            circuitSizes.add(circuitSize(node))
//        }
//    }
//
//    circuitSizes.sortDescending()
//    println(circuitSizes[0] * circuitSizes[1] * circuitSizes[2])

    // Part 2:
    val (first, second) = lastConnected
    println(first.triple.first * second.triple.first)
}

fun distanceSquared(p1: Triple<Long, Long, Long>, p2: Triple<Long, Long, Long>): Long {
    val (x, y, z) = p1
    val (u, v, w) = p2
    return Math.powExact(x - u, 2) + Math.powExact(y - v, 2) + Math.powExact(z - w, 2)
}

fun connected(n1: Node, n2: Node): Boolean {
    if (n1.connections.contains(n2)) {
        return true
    }

    val visited = mutableListOf<Node>()
    var foundPath = false
    fun visit(node: Node) {
        if (node.visited) {
            return
        }
        if (node != n1) {
            n1.connections.add(node)
        }
        visited.add(node)
        node.visited = true

        if (node.neighbors.contains(n2)) {
            n1.connections.add(n2)
            foundPath = true
            return
        }

        for (neighbor in node.neighbors) {
            visit(neighbor)
            if (foundPath) {
                return
            }
        }
    }

    visit(n1)

    for (node in visited) {
        node.visited = false
    }

    return foundPath
}

fun circuitSize(node: Node): Long {
    var size = 0L
    fun visit(node: Node) {
        if (node.visited) {
            return
        }
        node.visited = true
        size++

        for (neighbor in node.neighbors) {
            visit(neighbor)
        }
    }
    visit(node)
    return size
}
