package q16

import kotlin.math.log

/**
 * No.1680
 */
class `Concatenation of Consecutive Binary Numbers` {

    val D = (1e9 + 7.0).toLong()
    fun concatenatedBinary(n: Int): Int {
        var long = 0L
        repeat(n) {
            val num = it + 1
            val len = Math.floor(log(num.toDouble(), 2.0)) + 1.0
            long = ((long shl len.toInt()) + num) % D
        }

        return (long % D).toInt()
    }
}