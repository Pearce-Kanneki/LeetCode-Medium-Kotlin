package q03

/**
 * No.300
 */
class `Longest Increasing Subsequence` {

    fun lengthOfLIS(nums: IntArray): Int {
        val cache = IntArray(nums.size){ -1 }
        return lengthOfListHelper(nums, 0, Int.MIN_VALUE, cache)
    }

    fun lengthOfListHelper(array: IntArray, index: Int, lastElement: Int, cache: IntArray): Int {
        if (index >= array.size) return 0
        if (cache[index] != -1) return cache[index]

        var max = 0
        for (currentIndex in index until array.size) {
            if (lastElement < array[currentIndex]) {
                max = maxOf(max, lengthOfListHelper(array, currentIndex, array[currentIndex], cache) + 1)
            }
        }
        cache[index] = max

        return max
    }
}