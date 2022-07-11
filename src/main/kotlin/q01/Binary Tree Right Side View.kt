package q01

import java.util.*

/**
 * No.199
 */
class `Binary Tree Right Side View` {

    /**
     * 較快的方法
     */
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        if(root == null) return ans
        queue.offer(root)
        while(queue.size > 0){
            val level = queue.size
            for(i in 0..level-1){
                val node = queue.poll()
                if(i == level-1){
                    ans.add(node.`val`)
                }
                if(node.left != null) queue.offer(node.left)
                if(node.right != null) queue.offer(node.right)
            }
        }
        return ans
    }

    fun rightSideView1(root: TreeNode?): List<Int> {

        val result = mutableListOf<Int>()
        val queue: Queue<TreeNode> = LinkedList()

        root?.let { queue.offer(it) }

        while (queue.isNotEmpty()) {
            var index = 0
            val size = queue.size

            while (index < size) {
                val node = queue.poll()
                if (index == 0) result.add(node.`val`)
                node.right?.let { queue.offer(it) }
                node.left?.let { queue.offer(it) }
                index++

            }
        }

        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}