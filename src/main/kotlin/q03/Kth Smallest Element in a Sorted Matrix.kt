package q03

import java.util.PriorityQueue

/**
 * No.378
 */
class `Kth Smallest Element in a Sorted Matrix` {

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val pq = PriorityQueue<IntArray>(Comparator { o1, o2 ->
            return@Comparator o1[0] - o2[0]
        })

        for (i in matrix.indices) {
            pq.offer(intArrayOf(matrix[i][0], i, 0))
        }
        for (i in 0 until k - 1) {
            val now = pq.poll()
            if (now[2] != matrix.size - 1){
                pq.offer(intArrayOf(matrix[now[1]][now[2] + 1], now[1], now[2] + 1))
            }
        }

        return pq.poll()[0]
    }
}