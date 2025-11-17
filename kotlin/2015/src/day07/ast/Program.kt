package day07.ast

class Program(private val assignments: List<Assignment>) : AST() {
    override fun emit() {
        TODO()
//        val varsSeen = mutableSetOf<String>()
//        val assignmentsMut = assignments.toMutableList()
//        while (assignmentsMut.isNotEmpty()) {
//            val assignment = assignmentsMut[0]
//            when (assignment.expression) {
//                is Expression.And -> assignment.expression.leftOperand
//            }
//        }
    }
}
