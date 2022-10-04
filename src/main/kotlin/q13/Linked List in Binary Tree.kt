package q13

import q00.ListNode
import q01.TreeNode

/**
 * No.1367
 */
class `Linked List in Binary Tree` {

    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if (head == null) return true
        if (root == null) return false

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right)
    }

    private fun dfs(head: ListNode?, node: TreeNode?): Boolean {
        if (head == null) return true
        if (node == null) return false

        if (head.`val` != node.`val`) return false

        return dfs(head.next, node.left) || dfs(head.next, node.right)
    }
}