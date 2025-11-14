import java.io.File

fun main() {
    val lines = File("2022/input/day01.txt").readLines()
    val groups = parseInventories(lines)

    val top3 = groups
        .map { it.sum() }
        .sortedDescending()
        .take(3)

    // Part 1:
    println(top3[0])

    // Part 2:
    println(top3.sum())
}

fun parseInventories(lines: List<String>): List<List<Int>> {
    val inventories = mutableListOf<List<Int>>()
    var currentInventory = mutableListOf<Int>()

    for (line in lines) {
        if (line.isEmpty()) {
            inventories.add(currentInventory.toList())
            currentInventory = mutableListOf()
        } else {
            currentInventory.add(line.toInt())
        }
    }

    inventories.add(currentInventory.toList())

    return inventories.toList()
}
