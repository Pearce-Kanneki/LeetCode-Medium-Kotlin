package q04

import java.util.*
import kotlin.collections.ArrayDeque

/**
 * No.429
 */
class `N-ary Tree Level Order Traversal` {

    fun levelOrder(root: Node?): List<List<Int>> {
        root ?: return listOf()

        val queue = LinkedList<Pair<Node, Int>>()
        val result = mutableListOf<MutableList<Int>>()

        queue.add(Pair(root!!, 0))
        result.add(mutableListOf(root!!.`val`))

        while (queue.isNotEmpty()) {
            val nodeAndLevel = queue.poll()!!
            val childrenLevel = nodeAndLevel.second + 1

            if (result.size == childrenLevel) {
                result.add(mutableListOf())
            }

            for (node in nodeAndLevel.first.children) {
                queue.add(Pair(node!!, childrenLevel))
                result[childrenLevel].add(node!!.`val`)
            }
        }

        if (result.last().isEmpty()) result.removeAt(result.size - 1)

        return result
    }

    /**
     *
     */
    fun levelOrder1(root: Node?): List<List<Int>> {
        if (root == null) return listOf()
        val ans = mutableListOf<List<Int>>()
        val queue: Queue<Node> = ArrayDeque<Node>()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            var cnt = queue.size
            val level = mutableListOf<Int>()
            while (cnt > 0) {
                val cur = queue.poll()
                level.add(cur.`val`)
                cur.children.forEach { n ->
                    n?.let { queue.offer(it) }
                }
                --cnt
            }
            ans.add(level)
        }

        return ans
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}