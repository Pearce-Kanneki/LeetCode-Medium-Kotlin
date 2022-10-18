package q01

import java.util.*

/**
 * No.155
 */
class `Min Stack` {
}

class MinStack() {

    private val stack = Stack<Int>()
    private val minStack = Stack<IntArray>()

    fun push(`val`: Int) {
        stack.push(`val`)
        val currentMin = if (minStack.isNotEmpty()) {
            minStack.peek()
        } else null

        if (currentMin == null || `val` < currentMin[0]) {
            minStack.push(intArrayOf(`val`,1))
        } else if (`val` == currentMin[0]) {
            currentMin[1]++
        }
    }

    fun pop() {
        val min = minStack.peek()
        if (min[0] == stack.pop()) {
            if (min[1] == 1) {
                minStack.pop()
            } else {
                min[1]--
            }
        }
    }

    fun top(): Int = stack.peek()

    fun getMin(): Int = minStack.peek()[0]

}