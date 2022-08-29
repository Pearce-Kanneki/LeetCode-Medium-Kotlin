package q08

/**
 * No.869
 */
class `Reordered Power of 2` {

    fun reorderedPowerOf2(n: Int): Boolean {
        val signature = n.toString().groupBy { it }.map { it.key to it.value.size }.toMap()
        return (0..30).map { 1 shl it }
            .map {
                it.toString()
                    .groupBy { it }
                    .map { it.key to it.value.size }
                    .toMap()
            }.any { pow2 ->
                (signature.size == pow2.size) && signature.all { (pow2[it.key] ?: -1) == it.value }
            }
    }
}