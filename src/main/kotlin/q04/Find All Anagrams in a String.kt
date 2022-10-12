package q04

/**
 * No.438
 */
class `Find All Anagrams in a String` {

    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.isEmpty() || p.isEmpty() || s.length < p.length)
            return emptyList()

        val windowP = IntArray(26)
        val windowS = IntArray(26)
        val result = mutableListOf<Int>()
        for (i in p.indices) {
            windowP[p[i] - 'a']++
            windowS[s[i] - 'a']++
        }

        var start = 0
        if (windowP contentEquals windowS)
            result.add(start)

        for (i in p.length..s.lastIndex) {
            val count = windowS[s[start] - 'a'] - 1
            if (count >= 0)
                windowS[s[start] - 'a'] = count

            windowS[s[i] - 'a']++
            if (windowS contentEquals windowP)
                result.add(start + 1)
            start++
        }

        return result
    }
}