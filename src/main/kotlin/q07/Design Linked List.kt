package q07

/**
 * No.707
 */
class `Design Linked List` {
}

class MyLinkedList() {

    var head: Node? = null
    var length: Int = 0

    class Node(value: Int) {
        var value = value
        var next: Node? = null
    }

    fun get(index: Int): Int {
        if (head == null || index < 0 || index >= length) return -1
        var ptr = head
        for (i in 0 until index) {
            ptr = ptr?.next
        }
        try {
            return ptr!!.value
        } catch(e: Exception) {
            return -1
        }
    }

    fun addAtHead(`val`: Int) {
        if (head == null) {
            head = Node(`val`)
        } else {
            var newNode = Node(`val`)
            newNode.next = head
            head = newNode
        }
        length++
    }

    fun addAtTail(`val`: Int) {
        if (head == null) {
            addAtHead(`val`)
        } else {
            var ptr = head
            while (ptr?.next !== null) {
                ptr = ptr?.next
            }
            ptr?.next = Node(`val`)
        }
        length++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (head === null && index < 0) addAtHead(`val`)
        if (index < 0 || index > length) return
        if (index === 0) {
            addAtHead(`val`)
        } else if (index === length) {
            addAtTail(`val`)
        } else {
            var prevNode = head
            var ptr = head!!.next
            for (i in 1 until index) {
                prevNode = ptr
                ptr = ptr?.next
            }
            prevNode!!.next = Node(`val`)
            prevNode!!.next!!.next = ptr
            length++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= length) return
        if (index === 0) {
            head = head!!.next
        } else {
            var prevNode = head
            var ptr = head!!.next
            for (i in 1 until index) {
                prevNode = ptr
                ptr = ptr?.next
            }
            if (index === length) {
                prevNode?.next = null
            } else {
                prevNode!!.next = ptr!!.next
            }
        }
        length--
    }


}