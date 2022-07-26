package q07

import java.util.*

/**
 * No.792
 */
class `Number of Matching Subsequences` {

    fun numMatchingSubseq(s: String, words: Array<String>): Int {

        val memo = mutableMapOf<Char, Queue<StringBuilder>>()

        words.forEach {
            val list = memo.getOrPut(it.first()){ ArrayDeque() }
            list += StringBuilder(it)
        }

        var res = 0
        for (char in s) {
            val oldQueue = memo[char] ?: continue

            memo[char] = ArrayDeque()
            while (oldQueue.isNotEmpty()) {
                val word = oldQueue.poll()
                word.deleteCharAt(0)

                if (word.isEmpty()) {
                    res++
                } else {
                    val list = memo.getOrPut(word.first()) { ArrayDeque() }
                    list += StringBuilder(word)
                }
            }
        }

        return res
    }
}