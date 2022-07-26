package q02

import q01.TreeNode

/**
 * No.236
 */
class `Lowest Common Ancestor of a Binary Tree` {

    var ans: TreeNode? = null
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        dfs(root ,p, q)
        return ans
    }

    private fun dfs(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
        if (root == null) return false
        val lson = dfs(root.left, p, q)
        val rson = dfs(root.right, p, q)
        if ((lson && rson) || ((root.`val` == p?.`val` || root.`val` == q?.`val`) && (lson || rson))) {
            ans = root
        }

        return lson || rson || (root.`val` == p?.`val` || root.`val` == q?.`val`)
    }
}