fun main() {
    val lighting = Lighting()
    lighting.turnOn(0, 0, 2, 2)
    lighting.toggle(0, 999, 10, 999)
    lighting.toggle(5, 999, 15, 999)

    println(lighting.toString())
}

class Lighting {
    val width = 1000
    val height = 1000

    val grid = BooleanArray(width * height)

    fun turnOn(x: Int, y: Int) {
        this[y][x] = true
    }

    fun turnOn(x: Int, y: Int, u: Int, v: Int) {
        for (i in x..u) {
            for (j in y..v) {
                turnOn(i, j)
            }
        }
    }

    fun turnOff(x: Int, y: Int) {
        this[y][x] = false
    }

    fun turnOff(x: Int, y: Int, u: Int, v: Int) {
        for (i in x..u) {
            for (j in y..v) {
                turnOff(i, j)
            }
        }
    }

    fun toggle(x: Int, y: Int) {
        val row = this[y]
        row[x] = !row[x]
    }

    fun toggle(x: Int, y: Int, u: Int, v: Int) {
        for (i in x..u) {
            for (j in y..v) {
                toggle(i, j)
            }
        }
    }

    operator fun get(index: Int): BooleanArrayView {
        return BooleanArrayView(grid, index * width, width)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (y in 0 until height) {
            val row = this[y]
            for (x in 0 until width) {
                sb.append(if (row[x]) '1' else '0')
            }
            sb.append('\n')
        }
        return sb.toString()
    }
}

class BooleanArrayView(private val array: BooleanArray, private val start: Int, val size: Int) {
    operator fun get(index: Int): Boolean {
        require(index in 0 until size)
        return array[start + index]
    }

    operator fun set(index: Int, value: Boolean) {
        require(index in 0 until size)
        array[start + index] = value
    }
}
