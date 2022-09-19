package q06

/**
 * No.609
 */
class `Find Duplicate File in System` {

    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val map = HashMap<String, HashSet<String>>()
        paths.forEach { path ->
            val strs = path.split(" ")
            val dir = strs[0]

            for (i in 1 until strs.size) {
                val str = strs[i]
                val contentIdx = str.indexOf("(")
                val content = str.substring(contentIdx + 1).also { it.dropLast(1) }
                val fileName = dir + "/" + str.substring(0, contentIdx)
                map.getOrPut(content){ hashSetOf() }.add(fileName)
            }
        }

        val ans = ArrayList<List<String>>()
        map.forEach { (_, pathSet) ->
            if (pathSet.size > 1)
                ans.add(pathSet.toList())
        }

        return ans
    }
}