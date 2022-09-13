package q09

/**
 * No.984
 */
class `Bag of Tokens` {

    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        tokens.sort()
        var p = power
        var lo = 0
        var hi = tokens.lastIndex

        var points = 0
        var ans = 0
        while (lo <= hi && (p >= tokens[lo] || points > 0)) {
            while (lo <= hi && p >= tokens[lo]) {
                p -= tokens[lo++]
                points++
            }

            ans = maxOf(ans, points)
            if (lo <= hi && points > 0) {
                p += tokens[hi--]
                points--
            }
        }

        return ans
    }
}