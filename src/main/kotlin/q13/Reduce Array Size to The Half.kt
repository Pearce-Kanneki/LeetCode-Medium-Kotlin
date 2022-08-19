package q13

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

/**
 * No.1338
 */
class `Reduce Array Size to The Half` {

    /**
     * 
     */
    fun minSetSize(arr: IntArray): Int {
        val counts = HashMap<Int, Int>()
        for (i in arr) {
            counts.merge(i, 1) { t, u -> t + u }
        }
        val queue = PriorityQueue<Map.Entry<Int, Int>>(Comparator<Map.Entry<Int, Int>?> { o1, o2 -> o1!!.value.compareTo(o2!!.value) }.reversed())
        queue.addAll(counts.entries)
        var size = 0
        var result = 0
        while (size < arr.size / 2) {
            size += queue.poll().value
            result++
        }
        return result
    }

    /**
     *
     */
    fun minSetSize1(arr: IntArray): Int {

        val map = HashMap<Int, Int>()
        var resultSize = 0
        var deleteSize = 0
        arr.forEach { map[it] = map.getOrDefault(it, 0) + 1 }

        val values = map.values.sortedDescending()
        for (i in values) {
            deleteSize += i
            ++resultSize

            if (deleteSize >= arr.size / 2) break
        }

        return resultSize
    }
}