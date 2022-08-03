package q07

import java.util.TreeMap
import java.util.TreeSet

/**
 * No.729
 */
class `My Calendar I` {

    val set = TreeSet<Pair<Int, Int>>{ p1, p2 ->
        when {
            p1.second <= p2.first -> -1
            p2.second <= p1.first -> 1
            else -> 0
        }
    }
    fun book(start: Int, end: Int): Boolean {
        val pair = Pair(start, end)
        return when {
            set.contains(pair) -> false
            else -> {
                set.add(pair)
                true
            }
        }
    }
}