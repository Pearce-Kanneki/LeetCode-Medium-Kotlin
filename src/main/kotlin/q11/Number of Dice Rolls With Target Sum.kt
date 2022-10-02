package q11

/**
 * No.1155
 */
class `Number of Dice Rolls With Target Sum` {

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {

        val dp = Array(n + 1){ LongArray(target + 1) }
        dp[0][0] = 1

        val mod = (1e9 + 7).toInt()

        for (i in 1..n) {
            for (j in 1..target) {
                for (m in 1..k) {
                    if (j - m < 0) break

                    dp[i][j] = (dp[i][j] + dp[i-1][j-m]) % mod
                }
            }
        }

        return dp[n][target].toInt()
    }
}