package q14

import q01.TreeNode

/**
 * No.1448
 */
class `Count Good Nodes in Binary Tree` {

    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0

        return dfs(root, root.`val`)
    }

    private fun dfs(node: TreeNode, curNum: Int): Int {
        var sum = 0
        var maxNum = curNum
        if (node.`val` >= curNum) {
            ++sum
            maxNum = node.`val`
        }

        node.left?.let { sum += dfs(it, maxNum) }
        node.right?.let { sum += dfs(it, maxNum) }

        return sum
    }
}