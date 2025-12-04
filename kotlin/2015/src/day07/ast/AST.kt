package day07.ast

import java.io.PrintWriter

abstract class AST {
    abstract fun emit()

    companion object {
        var out = PrintWriter(System.out)
    }
}
