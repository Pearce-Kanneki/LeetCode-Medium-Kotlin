package q07

import java.util.*

/**
 * No.739
 */
class `Daily Temperatures` {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val ans = IntArray(temperatures.size)
        val stack: Deque<Int> = LinkedList<Int>()
        temperatures.forEachIndexed { index, item ->
            while (stack.isNotEmpty() && item > temperatures[stack.peek()]) {
                val prevIndex = stack.pop()
                ans[prevIndex] = index - prevIndex
            }
            stack.push(index)
        }

        return ans
    }
}