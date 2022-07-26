package q16

/**
 * No.1689
 */
class `Partitioning Into Minimum Number Of Deci-Binary Numbers` {

    fun minPartitions(n: String): Int {
        var maxIndex = 0
        n.forEach {
            when {
                it.toString().toInt() == 9 -> return 9
                it.toString().toInt() > maxIndex -> maxIndex = it.toString().toInt()
            }
        }

        return maxIndex
    }

    /**
     * 1行解
     */
    fun minPartitions2(n: String): Int {
        return n.map { it.toString().toInt() }.maxOrNull() ?: 0
    }
}