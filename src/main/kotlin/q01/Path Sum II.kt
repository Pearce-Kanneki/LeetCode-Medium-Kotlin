package q01

import java.util.Deque
import java.util.LinkedList

/**
 * No.113
 */
class `Path Sum II` {

    val ret: MutableList<List<Int>> = LinkedList<List<Int>>()
    val path: Deque<Int> = LinkedList<Int>()

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        dfs(root, targetSum)
        return ret
    }

    fun dfs(node: TreeNode?, targetSum: Int) {
        if (node == null) return

        var tar = targetSum
        path.offerLast(node.`val`)
        tar -= node.`val`
        if (node.left == null && node.right == null && tar == 0) {
            ret.add(LinkedList(path))
        }
        dfs(node.left, tar)
        dfs(node.right, tar)
        path.pollLast()
    }
}