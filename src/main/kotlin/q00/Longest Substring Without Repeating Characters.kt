package q00

/**
 * No.3
 */
class `Longest Substring Without Repeating Characters` {

    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var maxNum = 0
        var left = 0
        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                left = maxOf(left, map.getOrDefault(s[i], 0) + 1)
            }

            map[s[i]] = i
            maxNum = maxOf(maxNum, i - left + 1)
        }

        return maxNum
    }
}