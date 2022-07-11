package q00

/**
 * No.97
 */
class `Interleaving String` {

    fun isInterleave(s1: String, s2: String, s3: String): Boolean {

        if (s1.length + s2.length != s3.length) return false

        val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) { false } }

        for (i in 0..s1.length) {
            for (j in 0..s2.length) {
                dp[i][j] = when {
                    i == 0 && j == 0 -> true
                    i == 0 -> dp[i][j - 1] && s2[j - 1] == s3[j - 1]
                    j == 0 -> dp[i - 1][j] && s1[i - 1] == s3[i - 1]
                    else -> {
                        val idx = i + j - 1
                        (dp[i - 1][j] && s1[i - 1] == s3[idx] || dp[i][j - 1] && s2[j - 1] == s3[idx])
                    }
                }
            }
        }

        return dp[s1.length][s2.length]
    }
}