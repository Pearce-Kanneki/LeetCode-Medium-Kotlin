package q00

/**
 * No.5
 */
class `Longest Palindromic Substring` {

    fun longestPalindrome(s: String): String {
        var longest = ""

        fun check(i: Int, j: Int) {
            var l = i; var r = j

            while (l >= 0 && r < s.length) {
                if (s[l] != s[r]) break

                if (r - l + 1 > longest.length)
                    longest = s.substring(l..r)

                l--; r++
            }
        }

        for (i in s.indices) {
            check(i, i)
            check(i, i + 1)
        }

        return longest
    }
}