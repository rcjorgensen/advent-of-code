package day05

class Node(val range: LongRange, val neighbors: MutableList<Node> = mutableListOf(), var visited: Boolean = false) {
    fun overlaps(other: Node) = range.first <= other.range.last && other.range.first <= range.last
}
