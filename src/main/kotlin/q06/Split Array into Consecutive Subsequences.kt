package q06

/**
 * No.659
 */
class `Split Array into Consecutive Subsequences` {

    fun isPossible(nums: IntArray): Boolean {
        if (nums.size < 3) return false
        val distinctNums = nums.distinct()
        val numOccurs = nums.groupBy { it }.map { it.key to it.value.size }.toMap()
        val pairs = distinctNums.map { it to numOccurs[it]!! }
        var p = 0
        while (p < distinctNums.size) {
            var q = p + 1
            while (q < distinctNums.size && pairs[q].first == pairs[q - 1].first + 1)
                q++
            if (!check(pairs, p, q - 1)) return false
            p = q
        }
        return true
    }

    private fun check(pairs: List<Pair<Int, Int>>, p : Int, q: Int): Boolean {
        val len1 = IntArray(q - p + 1){ if (it == 0) pairs[p].second else 0 }
        val len2 = IntArray(q - p + 1)

        for (i in p + 1.. q) {
            if (pairs[i].second < len1[i - 1 - p] + len2[i - 1 - p]) return false
            len2[i - p] = len1[i - 1 - p]
            len1[i - p] = maxOf(0, pairs[i].second - pairs[i - 1].second)
        }

        return len1[q - p] == 0 && len2[q - p] == 0
    }
}