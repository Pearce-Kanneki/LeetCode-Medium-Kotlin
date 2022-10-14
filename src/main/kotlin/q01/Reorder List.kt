package q01

import q00.ListNode

/**
 * No.143
 */
class `Reorder List` {

    fun reorderList(head: ListNode?): Unit {
        head ?: return

        val middleNode = head.findMiddle()

        val rightHalfHead = middleNode.next ?: return

        // println("right half head is ${rightHalfHead.`val`}")

        middleNode.next = null

        var reversedNode = rightHalfHead.reversed()
        var normalNode = head

        while(normalNode != null && reversedNode != null) {
            val originalNormalNext = normalNode.next
            val originalReversedNext = reversedNode.next

            reversedNode.next = originalNormalNext
            normalNode.next = reversedNode

            normalNode = originalNormalNext
            reversedNode = originalReversedNext
        }

    }

    private fun ListNode.reversed(): ListNode? {

        var curNode: ListNode? = this
        var prevNode: ListNode? = null

        while (curNode != null) {
            val originalNext = curNode.next

            curNode.next = prevNode
            prevNode = curNode

            curNode = originalNext
        }

        return prevNode
    }

    private fun ListNode.findMiddle(): ListNode {
        var slowPtr = this
        var fastPtr = this

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next
            fastPtr = fastPtr.next.next
        }

        return slowPtr
    }
}