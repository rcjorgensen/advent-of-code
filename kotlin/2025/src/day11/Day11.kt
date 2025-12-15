package day11

import common.Source
import day11.ast.Device

fun main() {
    val parser = Parser(Scanner(Source.fromPath("src/day11/input.txt")))
    parser.parseInput()
    val visited = mutableSetOf<Device>()
//    val you = parser.deviceTable["you"] ?: error("Device 'you' not found.")
    val svr = parser.deviceTable["svr"] ?: error("Device 'svr' not found.")

    var dacOnStack = false
    var fftOnStack = false
    var count = 0
    fun visit(device: Device) {
        if (device.name == "dac") {
            dacOnStack = true
        }
        if (device.name == "fft") {
            fftOnStack = true
        }

        if (device.name == "out") {
            if (dacOnStack && fftOnStack) {
                count++
            }
            return
        }

        if (visited.contains(device)) {
            return
        }
        visited.add(device)

        for (target in device.targets) {
            visit(target)
        }

        if (device.name == "dac") {
            dacOnStack = false
        }
        if (device.name == "fft") {
            fftOnStack = false
        }
        visited.remove(device)
    }

    visit(svr)

    println(count)
}
