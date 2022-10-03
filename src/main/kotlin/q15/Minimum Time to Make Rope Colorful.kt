package q15

/**
 * No.1578
 */
class `Minimum Time to Make Rope Colorful` {

    fun minCost(colors: String, neededTime: IntArray): Int {
        var i = 0
        var ans = 0

        while (i < colors.length) {
            val ch = colors[i]
            var maxValue = 0
            var sum = 0

            while (i < colors.length && colors[i] == ch) {
                maxValue = maxOf(maxValue, neededTime[i])
                sum += neededTime[i]
                i++
            }
            ans += sum - maxValue
        }

        return ans
    }
}