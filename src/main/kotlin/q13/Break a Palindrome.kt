package q13

/**
 * No.1328
 */
class `Break a Palindrome` {

    fun breakPalindrome(palindrome: String): String {
        return if (palindrome.length == 1) {
            ""
        } else {
            palindrome.indexOfFirst { it != 'a' }
                .takeIf { it != -1 && it < palindrome.length / 2 }
                ?.let { index ->
                    StringBuilder(palindrome).also { it[index] = 'a' }.toString()
                } ?: run {
                StringBuilder(palindrome).also { it[it.lastIndex] = 'b' }.toString()
            }
        }
    }
}