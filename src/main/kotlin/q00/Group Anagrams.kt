package q00

/**
 * No.49
 */
class `Group Anagrams` {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        strs.forEach {
            val array = it.toCharArray().apply { sort() }
            String(array).apply {
                val list = map.getOrDefault(this, mutableListOf())
                    .apply { add(it) }
                map[this] = list
            }
        }

        return map.values.toList()
    }
}