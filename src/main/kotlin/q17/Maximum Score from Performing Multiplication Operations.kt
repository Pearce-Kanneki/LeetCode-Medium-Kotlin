package q17

/**
 * No.1770
 */
class `Maximum Score from Performing Multiplication Operations` {

    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val memo = Array<IntArray>(multipliers.size){ IntArray(multipliers.size) }

        return dp(0, nums, 0, multipliers, memo)
    }

    private fun dp(left: Int, nums: IntArray, i: Int, multipliers: IntArray, memo: Array<IntArray>): Int {
        if(i > multipliers.lastIndex) return 0
        if (memo[left][i] != 0) return memo[left][i]
        val right = nums.lastIndex - (i - left)
        val useLeft = dp(left + 1, nums, i + 1, multipliers, memo) + nums[left] * multipliers[i]
        val useRight = dp(left, nums, i + 1, multipliers, memo) + nums[right] * multipliers[i]
        val result = maxOf(useLeft, useRight)
        memo[left][i] = result

        return result
    }
}