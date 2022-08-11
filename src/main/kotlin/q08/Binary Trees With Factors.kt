package q08

/**
 * No.823
 */
class `Binary Trees With Factors` {

    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val factorList = arr.map { it.toLong() to mutableListOf<Pair<Long, Long>>() }.toMap()
        repeat(arr.size) { i ->
            repeat(arr.size){ j ->
                factorList[arr[i].toLong() * arr[j].toLong()]?.add(Pair(arr[i].toLong(), arr[j].toLong()))
            }
        }

        arr.sort()

        val trees = hashMapOf<Long, Long>()
        var totalBinaryTrees = 0
        for (i in 0 until arr.size) {
            var binaryTrees = 1L
            for (pair in factorList[arr[i].toLong()]!!) {
                binaryTrees += trees[pair.first]!! * trees[pair.second]!!
            }
            trees[arr[i].toLong()] = binaryTrees
            totalBinaryTrees = (totalBinaryTrees + (binaryTrees % 1000000007).toInt()) % 1000000007
        }

        return totalBinaryTrees
    }
}