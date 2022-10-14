package q09

/**
 * No.910
 */
class `Smallest Range II` {

    fun smallestRangeII(nums: IntArray, k: Int): Int {
        nums.sort()
        var ans = nums.last() - nums.first()

        for (i in 0 until nums.size - 1) {
            val a = nums[i]
            val b = nums[i + 1]

            val hight = maxOf(nums.last() - k, a + k)
            val low = minOf(nums.first() + k, b - k)
            ans = minOf(ans, hight - low)
        }

        return ans
    }
}