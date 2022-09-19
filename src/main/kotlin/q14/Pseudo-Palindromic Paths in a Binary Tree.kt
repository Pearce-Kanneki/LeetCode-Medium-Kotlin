package q14

import q01.TreeNode

/**
 * No.1457
 */
class `Pseudo-Palindromic Paths in a Binary Tree` {

    private val digits = IntArray(10)
    private var ans = 0

    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        dfs(root)

        return ans
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) return

        digits[node.`val`]++
        if (node.left == null && node.right == null && (1..9).count { digits[it] % 2 == 1 } < 2)
            ans++

        dfs(node.left)
        dfs(node.right)

        digits[node.`val`]--
    }
}