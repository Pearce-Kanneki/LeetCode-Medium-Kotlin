package q00

import java.util.*

/**
 * No.19
 */
class `Remove Nth Node From End of List` {

    /**
     *
     */
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        //two pointers
        //Second pointers runs ahead n
        var slowPtr = head
        var fastPtr = head

        for(i in 1..n) {
            fastPtr = fastPtr?.next
        }

        if(fastPtr == null)
            return head?.next

        while(fastPtr?.next != null) {
            slowPtr = slowPtr?.next
            fastPtr = fastPtr?.next
        }

        slowPtr?.next = slowPtr?.next?.next

        return head

    }

    /**
     *
     */
    fun removeNthFromEnd1(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply { next = head }

        val stack: Deque<ListNode> = LinkedList<ListNode>()
        var cur: ListNode? = dummy
        while (cur != null) {
            stack.push(cur)
            cur = cur.next
        }

        repeat(n) {
            stack.pop()
        }

        val prev = stack.peek()
        prev.next = prev.next?.next

        return dummy.next
    }
}