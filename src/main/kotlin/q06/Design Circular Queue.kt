package q06

/**
 * No.622
 */
class MyCircularQueue(k: Int) {

    private var head = -1
    private var tail = -1
    private val length = k
    private val queueList = IntArray(k)

    fun enQueue(value: Int): Boolean {
        val isEnqueued: Boolean

        when{
            head == -1 -> {
                head++
                tail++
                queueList[head] = value
                isEnqueued = true
            }
            tail == length - 1 && head == 0 -> {
                isEnqueued = false
            }
            tail == length - 1 && head != 0 -> {
                tail = 0
                queueList[tail] = value
                isEnqueued = true
            }
            tail == head - 1 -> {
                isEnqueued = false
            }
            else -> {
                tail++
                queueList[tail] = value
                isEnqueued = true
            }
        }

        return isEnqueued ?: false
    }

    fun deQueue(): Boolean {
        if (head == -1 && tail == -1) return false

        when(head) {
            tail -> {
                head = -1
                tail = -1
            }
            length - 1 -> head = 0
            else -> head++
        }

        return true
    }

    fun Front(): Int {

        return if (head == -1) -1 else queueList[head]
    }

    fun Rear(): Int {
        return if (tail == -1) -1 else queueList[tail]
    }

    fun isEmpty(): Boolean {
        return head == -1 && tail == -1
    }

    fun isFull(): Boolean {
        return tail == length - 1 && head == 0 || tail == head - 1
    }
}