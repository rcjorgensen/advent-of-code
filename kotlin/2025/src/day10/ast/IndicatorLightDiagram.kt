package day10.ast

data class IndicatorLightDiagram(val lights: UInt, val length: Int) {
    override fun toString(): String {
        val buffer = StringBuilder(length)
        for (i in 0..<length) {
            buffer.append(if (lights and (1U shl i) != 0U) '#' else '.')
        }
        return buffer.toString()
    }
}
