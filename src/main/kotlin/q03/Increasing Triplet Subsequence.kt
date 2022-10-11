package q03

/**
 * No.334
 */
class `Increasing Triplet Subsequence` {

    fun increasingTriplet(nums: IntArray): Boolean {
        val n = nums.size
        val f = intArrayOf(0, Int.MAX_VALUE, Int.MAX_VALUE)
        for (i in 0 until n) {
            val t = nums[i]

            if (f[2] < t) return true
            else if (f[1] < t && t < f[2]) f[2] = t
            else if (f[1] > t) f[1] = t
        }

        return false
    }
}