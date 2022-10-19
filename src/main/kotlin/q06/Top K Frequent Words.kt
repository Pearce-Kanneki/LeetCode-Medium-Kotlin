package q06

import java.util.PriorityQueue

/**
 * No.692
 */
class `Top K Frequent Words` {

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = HashMap<String, Int>()
        val pq = PriorityQueue<String> { a, b ->
            if (map[b]!! == map[a]!!) {
                a.compareTo(b)
            } else {
                map[b]!! - map[a]!!
            }
        }
        val ret = mutableListOf<String>()
        var nK = k
        words.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        map.forEach { (key, _) ->
            pq.offer(key)
        }

        while (nK > 0) {
            ret.add(pq.poll())
            nK--
        }

        return ret
    }
}