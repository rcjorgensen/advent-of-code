package day07.ast

class Input(private val assignments: List<Assignment>) : AST() {
    override fun emit() {
        out.println("// This file has been auto generated.")
        out.println("package day07")
        out.println()
        out.println("fun main() {")
        out.println("    // To solve part 2, run part 1, assign result to `b` and rerun.")
        for (assignment in assignments) {
            assignment.emit()
        }
        out.println("   println(a)")
        out.println("}")
    }
}
