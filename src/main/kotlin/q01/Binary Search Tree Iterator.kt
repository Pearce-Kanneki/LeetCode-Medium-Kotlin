package q01

/**
 * No.173
 */
class `Binary Search Tree Iterator` {
}

class BSTIterator(root: TreeNode?) {

    val stack = java.util.ArrayDeque<TreeNode>()

    init {
        var node = root

        while (node != null) {
            stack.push(node)
            node = node.left
        }
    }

    fun next(): Int {
        val top = stack.pop()
        var node = top.right

        while (node != null) {
            stack.push(node)
            node = node.left
        }

        return top.`val`
    }

    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

}