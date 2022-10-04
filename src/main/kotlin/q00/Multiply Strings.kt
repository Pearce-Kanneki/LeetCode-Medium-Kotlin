package q00

/**
 * No.45
 */
class `Multiply Strings` {

    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        val len1 = num1.length
        val len2 = num2.length
        val sum = IntArray(len1 + len2)

        for (i in (len1 - 1) downTo 0) {
            val n1 = num1[i] - '0'
            for (j in (len2 - 1) downTo 0) {
                val n2 = num2[j] - '0'
                sum[i + j + 1] += n1 * n2
            }
        }

        val ans = StringBuilder()
        var carry = 0

        for (i in (len1 + len2 - 1) downTo 0) {
            val n = (sum[i] + carry) % 10
            carry = (sum[i] + carry) / 10
            ans.append(n)
        }
        if (ans.last() == '0') ans.deleteCharAt(ans.lastIndex)
        return ans.reversed().toString()
    }
}