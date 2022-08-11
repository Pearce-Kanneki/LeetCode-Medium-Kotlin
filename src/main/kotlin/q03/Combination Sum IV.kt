package q03

/**
 * No.377
 */
class `Combination Sum IV` {

    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1) {0}
        dp[0] = 1
        for (i in 1..target) {
            nums.forEach {
                if (it <= i) {
                    dp[i] += dp[i - it]
                }
            }
        }

        return dp[target]
    }
}