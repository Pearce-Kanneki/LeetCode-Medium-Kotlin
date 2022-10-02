package q00

/**
 * No.91
 */
class `Decode Ways` {

    fun numDecodings(s: String): Int {

        if (s.isEmpty()) return 0

        val n = s.length
        val tabulation = IntArray(n + 1)
        tabulation[0] = 1
        tabulation[1] = if (s[0] != '0') 1 else 0

        for (i in 2..n) {

            val singleDigit = s.substring(i - 1).toInt()
            if (singleDigit in 1..9) {
                tabulation[i] += tabulation[i - 1]
            }

            val doubleDigit = s.substring(i - 2, i).toInt()

            if (doubleDigit in 10..26) {
                tabulation[i] += tabulation[i -2]
            }
        }

        return tabulation[n]
    }
}