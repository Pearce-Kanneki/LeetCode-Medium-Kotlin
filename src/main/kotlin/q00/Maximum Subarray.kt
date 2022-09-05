package q00

/**
 * No.53
 */
class `Maximum Subarray` {

    fun maxSubArray(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var sum = 0
        nums.forEach {
            sum += it
            result = maxOf(result, sum)

            if (sum < 0) sum = 0
        }

        return result
    }
}