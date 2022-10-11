package q13

import java.util.LinkedList
import java.util.Queue

/**
 * No.1376
 */
class `Time Needed to Inform All Employees` {

    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        if (n == 1) return 0

        val employees = mutableListOf<Node>()
        for (i in informTime.indices)
            employees.add(Node(i, informTime[i]))

        val graph = Array(n){ LinkedList<Node>()}
        for (i in manager.indices) {
            val m = manager[i]
            if (m != -1) {
                graph[m].add(employees[i])
            }
        }

        return bfs(graph, employees[headID])
    }

    private fun bfs(graph: Array<LinkedList<Node>>, start: Node): Int {
        var max = 0
        val queue: Queue<Node> = LinkedList()
        queue.add(start)

        while (queue.isNotEmpty()) {
            var node = queue.poll()
            node = node.copy(informed = true)
            max = maxOf(max, node.time)
            for (adj in graph[node.id]) {
                if (!adj.informed)
                    queue.add(adj.copy(time = adj.time + node.time))
            }
        }

        return max
    }

    data class Node(
        val id: Int,
        val time: Int,
        val informed: Boolean = false
    )
}