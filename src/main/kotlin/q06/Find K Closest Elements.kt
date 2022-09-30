package q06

/**
 * No.658
 */
class `Find K Closest Elements` {

    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        if (arr.size == k) return arr.toList()

        var start = 0
        var end = arr.lastIndex

        while (start + k <= end) {
            val a = arr[start]
            val b = arr[end]

            if (Math.abs(a - x) <= Math.abs(b - x)) end-- else start++
        }

        return arr.slice(start..end)
    }
}