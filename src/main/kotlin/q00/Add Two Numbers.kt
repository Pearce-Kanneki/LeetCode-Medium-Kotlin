package q00

/**
 * No.2
 */
class `Add Two Numbers` {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val ans = ListNode(0)
        var cur = ans

        var carry = 0
        var x1 = l1
        var x2 = l2
        while (x1 != null || x2 != null) {

            ((x1?.`val` ?: 0) + (x2?.`val` ?: 0) + carry).also {
                cur.next = ListNode(it % 10)
                carry = it / 10
                cur = cur.next!!
            }

            x1 = x1?.next
            x2 = x2?.next
        }

        if (carry > 0)
            cur.next = ListNode(carry)

        return ans.next
    }
}