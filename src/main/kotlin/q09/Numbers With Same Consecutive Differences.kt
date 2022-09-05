package q09

import java.util.LinkedList

/**
 * No.967
 */
class `Numbers With Same Consecutive Differences` {

    fun numsSameConsecDiff(n: Int, k: Int): IntArray {

        if(n == 1) return (0..9).map { it }.toIntArray()

        var queue = LinkedList<Int>().also { q -> (0..9).drop(1).forEach { q.add(it) } }

        repeat(n - 1) {
            val nextLevelQueue = LinkedList<Int>()

            queue.forEach { num ->
                val tailDigit = num % 10
                val nextDigits = mutableListOf(tailDigit + k)
                if (k > 0) nextDigits.add(tailDigit - k)

                nextDigits.filter { it in 0..9 }
                    .mapTo(nextLevelQueue) { num * 10 + it}
            }

            queue = nextLevelQueue
        }

        return queue.sorted().toIntArray()
    }
}