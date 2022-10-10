package q05

/**
 * No.556
 */
class `Next Greater Element III` {

    fun nextGreaterElement(n: Int): Int {
        val s = n.toString().toCharArray()
        var i = s.size - 2

        while (i >= 0 && s[i] >= s[i + 1])
            i--

        if (i < 0) return -1

        var j = s.size - 1
        while (j >= 0 && s[j] <= s[i])
            j--

        s[i] = s[j].also { s[j] = s[i] }

        i++
        j = s.size - 1
        while (i < j) {
            s[i] = s[j].also { s[j] = s[i] }
            i++
            j--
        }

        val ret = String(s).toLong()

        return if (ret > Int.MAX_VALUE) -1 else ret.toInt()
    }
}