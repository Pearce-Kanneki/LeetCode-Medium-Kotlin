package q04

/**
 * No.473
 */
class `Matchsticks to Square` {

    fun makesquare(matchsticks: IntArray): Boolean {

        if (matchsticks.sum() % 4 != 0) return false

        val l = matchsticks.sum() / 4
        matchsticks.sort()
        matchsticks.reverse()

        val edges = IntArray(4)

        return dfs(0, matchsticks, edges, l)
    }

    fun dfs(index:Int, matchsticks: IntArray, edges: IntArray, len:Int): Boolean {
        if (index == matchsticks.size) return true

        for (i in edges.indices) {
            edges[i] += matchsticks[index]
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true
            }
            edges[i] -= matchsticks[index]
        }

        return false
    }
}