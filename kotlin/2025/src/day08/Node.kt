package day08

class Node(
    val triple: Triple<Long, Long, Long>,
    val neighbors: MutableList<Node> = mutableListOf(),
    val connections: MutableList<Node> = mutableListOf(),
    var visited: Boolean = false,
)
