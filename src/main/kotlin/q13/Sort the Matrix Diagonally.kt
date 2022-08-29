package q13

import java.util.*
import kotlin.collections.HashMap

/**
 * No.1329
 */
class `Sort the Matrix Diagonally` {

    /**
     *
     */
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val data: HashMap<Int, PriorityQueue<Int>> = hashMapOf()
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                data.computeIfAbsent(i - j) { PriorityQueue() }.add(mat[i][j])
            }
        }
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                mat[i][j] = data[i - j]!!.poll()
            }
        }
        return mat
    }

    /**
     *
     */
    fun diagonalSort1(mat: Array<IntArray>): Array<IntArray> {
        val queue = mutableListOf<Int>()
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (i != 0 && j != 0) continue

                queue.clear()
                var add = 0
                while ((i + add) < mat.size && (j + add) < mat[i + add].size) {
                    queue.add(mat[i + add][j + add])
                    add++
                }

                if (queue.size > 1) {
                    queue.sort()
                    for (index in queue.indices) {
                        mat[i + index][j + index] = queue[index]
                    }
                }
            }
        }

        return mat
    }
}