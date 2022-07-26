package q00

/**
 * No.92
 */
class `Reverse Linked List II` {

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        val dummyNode = ListNode(-1)
        dummyNode.next = head

        var prev: ListNode? = dummyNode
        var curr = dummyNode.next

        for (i in 1 until left) {
            prev = curr
            curr = curr?.next
        }

        val conn = prev
        val tail = curr

        for (i in left..right) {
            val temp = curr?.next
            curr?.next = prev
            prev = curr
            curr = temp
        }

        conn?.next = prev
        tail?.next = curr

        return dummyNode.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}