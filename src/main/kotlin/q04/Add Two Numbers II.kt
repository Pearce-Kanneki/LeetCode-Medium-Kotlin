package q04

import q00.ListNode
import java.util.Deque
import java.util.Stack

/**
 * No.445
 */
class `Add Two Numbers II` {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        if (l1 == null && l2 == null) return null
        if (l1 == null && l2 != null) return l2
        if (l1 != null && l2 == null) return l1

        val q1: Stack<Int> = Stack()
        val q2: Stack<Int> = Stack()
        var sum = 0
        var (a,b) = l1 to l2

        while (a != null) {
            sum += a.`val`
            q1.push(a.`val`)
            a = a.next
        }

        while (b != null) {
            sum += b.`val`
            q2.push(b.`val`)
            b = b.next
        }

        if (sum == 0) return ListNode(0)
        var resultTail: ListNode? = null
        var resultHead: ListNode? = null
        var carry = 0
        while (q1.isNotEmpty() || q2.isNotEmpty()) {
            sum = carry
            if (q1.isNotEmpty()) sum += q1.pop()
            if (q2.isNotEmpty()) sum += q2.pop()
            resultHead = ListNode(sum % 10).apply { next = resultTail }
            resultTail = resultHead
            carry = sum / 10
        }
        if (carry != 0) resultHead = ListNode(carry).apply { next = resultTail }
        return resultHead

    }
}