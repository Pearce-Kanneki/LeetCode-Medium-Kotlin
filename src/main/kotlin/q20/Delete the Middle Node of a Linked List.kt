package q20

import q00.ListNode

/**
 * No.2095
 */
class `Delete the Middle Node of a Linked List` {

    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var slow = head
        var fast = head
        var pre: ListNode? = null
        while (fast?.next != null) {
            fast = fast.next?.next
            pre = slow
            slow = slow?.next
        }
        pre?.next = pre?.next?.next

        return head
    }
}