package q01

import java.util.*

/**
 * No.114
 */
class `Flatten Binary Tree to Linked List` {

    /**
     * 較快的方法
     */
    fun flatten(root: TreeNode?): Unit {
        if (root == null) return
        flatten(root.left)
        flatten(root.right)
        if (root.left != null) {
            var left = root.left
            while (left?.right != null) { left = left.right }
            left?.right = root.right
            root.right = root.left
            root.left = null
        }
    }

    /**
     *
     */
    fun flatten1(root: TreeNode?): Unit {
        val list = mutableListOf<TreeNode>()
        val stack = LinkedList<TreeNode>()

        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                list.add(node)
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            node = node.right
        }

        for (i in 1 until list.size) {
            list[i - 1].apply {
                left = null
                right = list[i]
            }
        }
    }
}