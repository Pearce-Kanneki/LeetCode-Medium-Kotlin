package q20

/**
 * No.2007
 */
class `Find Original Array From Doubled Array` {

    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.isEmpty() || changed.size % 2 != 0) return intArrayOf()

        val answer = mutableListOf<Int>()
        val needed = mutableMapOf<Int, Int>()

        changed.sort()

        changed.forEach {
            if (needed.contains(it) && needed[it]!! > 0) {
                val amountNeeded = needed[it]!!
                needed[it] = amountNeeded - 1
            } else {

                val amountNeeded: Int = if (needed.contains(it * 2)) {
                    needed[it * 2]!! + 1
                } else {
                    1
                }

                answer.add(it)
                needed[it * 2] = amountNeeded
            }
        }

        needed.values.forEach {
            if (it > 0) return intArrayOf()
        }

        return answer.toIntArray()
    }
}