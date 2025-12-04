package day07

import day07.ast.Assignment

data class TreeNode(
    val assignment: Assignment,
    val children: MutableList<TreeNode> = mutableListOf(),
    var visited: Boolean = false,
)
