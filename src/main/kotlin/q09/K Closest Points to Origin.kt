package q09

import java.util.*

/**
 * No.973
 */
class `K Closest Points to Origin` {

    /**
     *
     */
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray> { p1, p2 -> square(p2) - square(p1) }
        for (point in points) {
            pq.add(point)
            if (pq.size > k) {
                pq.remove()
            }
        }
        return Array(pq.size) { pq.remove() }
    }

    private fun square(point: IntArray): Int {
        return point[0] * point[0] + point[1] * point[1]
    }

    /**
     *
     */
    fun kClosest1(points: Array<IntArray>, k: Int): Array<IntArray> {
        points.sortBy { it[0] * it[0] + it[1] * it[1]}

        return points.copyOfRange(0, k)
    }
}