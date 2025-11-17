package day06

class Lighting {
    val width = 1000
    val height = 1000

    val grid = IntArray(width * height)

    private fun index(x: Int, y: Int): Int = y * width + x

    fun turnOn(x: Int, y: Int, u: Int, v: Int) {
        for (i in x..u) {
            for (j in y..v) {
                grid[index(i, j)] = 1
            }
        }
    }

    fun turnOff(x: Int, y: Int, u: Int, v: Int) {
        for (i in x..u) {
            for (j in y..v) {
                grid[index(i, j)] = 0
            }
        }
    }

    fun toggle(x: Int, y: Int, u: Int, v: Int) {
        for (i in x..u) {
            for (j in y..v) {
                grid[index(i, j)] = if (grid[index(i, j)] == 1) 0 else 1
            }
        }
    }

    fun inc(x: Int, y: Int, u: Int, v: Int, times: Int = 1) {
        for (i in x..u) {
            for (j in y..v) {
                repeat(times) {
                    grid[index(i, j)]++
                }
            }
        }
    }

    fun dec(x: Int, y: Int, u: Int, v: Int) {
        for (i in x..u) {
            for (j in y..v) {
                if (grid[index(i, j)] > 0) {
                    grid[index(i, j)]--
                }
            }
        }
    }

    fun sum() = grid.sum()
}
