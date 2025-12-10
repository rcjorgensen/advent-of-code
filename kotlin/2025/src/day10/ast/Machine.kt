package day10.ast

import java.io.PrintWriter

class Machine(
    private val indicatorLightDiagram: IndicatorLightDiagram,
    private val joltageRequirements: IntArray,
    private val buttons: List<Button>,
) {
    var out = PrintWriter(System.out)
    fun emit() {
        val vars = mutableListOf<String>()
        for (i in 0..<buttons.size) {
            vars.add("x$i")
        }
        out.println("Minimize")
        out.println("  obj: ${vars.joinToString(" + ")}")
        out.println()
        out.println("Subject To")
        for ((i, value) in joltageRequirements.withIndex()) {
            val vars = mutableListOf<String>()
            for (j in 0..<buttons.size) {
                if (buttons[j].positions.contains(i)) {
                    vars.add("x$j")
                }
            }
            out.println("  c$i: ${vars.joinToString(" + ")} = $value")
        }
        out.println()
        out.println("Bounds")
        for (variable in vars) {
            out.println("  $variable >= 0")
        }
        out.println()
        out.println("Generals")
        out.println("  ${vars.joinToString(" ")}")
        out.println()
        out.println("End")
    }
}
