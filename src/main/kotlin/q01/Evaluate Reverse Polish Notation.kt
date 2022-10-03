package q01

import java.util.*

/**
 * No.150
 */
class `Evaluate Reverse Polish Notation` {

    fun evalRPN(tokens: Array<String>): Int {
        val st = Stack<Int>()
        tokens.forEach { str ->
            str.toIntOrNull()?.let {
                st.push(it)
            } ?: run {
                val num1 = st.pop()
                val num2 = st.pop()
                when(str) {
                    "+" -> st.push(num2 + num1)
                    "-" -> st.push(num2 - num1)
                    "*" -> st.push(num2 * num1)
                    "/" -> st.push(num2 / num1)
                    else -> {}
                }
            }
        }

        return st.pop()
    }
}