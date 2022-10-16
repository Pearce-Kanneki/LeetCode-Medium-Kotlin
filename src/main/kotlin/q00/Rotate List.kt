package q00

/**
 * No.61
 */
class `Rotate List` {

    fun rotateRight(head: ListNode?, k: Int): ListNode? {

        if (head == null) return null
        var len = 0
        var node = head

        while (node != null) {
            node = node.next
            len++
        }

        node = head
        val newK = k % len

        if (newK == 0) return head
        for (i in 1 until len-newK) {
            node = node?.next
        }

        val ret = node?.next
        node?.next = null

        node = ret
        while (node?.next != null) {
            node = node.next
        }

        node?.next = head

        return ret
    }
}