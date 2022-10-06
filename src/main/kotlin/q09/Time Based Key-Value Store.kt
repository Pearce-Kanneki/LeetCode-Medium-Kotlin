package q09

import java.util.*

/**
 * No.981
 */
class `Time Based Key-Value Store` {

    private val map: MutableMap<String, TreeMap<Int, String>> = mutableMapOf()

    fun set(key: String, value: String, timestamp: Int) {
        val sortTimeMap = map.getOrDefault(key, TreeMap())
        sortTimeMap[timestamp] = value
        map[key] = sortTimeMap
    }

    fun get(key: String, timestamp: Int): String {
        return map[key]?.floorEntry(timestamp)?.value ?: ""
    }

}