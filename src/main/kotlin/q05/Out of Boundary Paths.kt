package q05

/**
 * No.576
 */
class `Out of Boundary Paths` {

    val mod = (1e9 + 7).toInt()
    var row = 0
    var colum = 0
    var maxNum = 0
    val dirs = listOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0, -1))
    val cache = mutableListOf<MutableList<MutableList<Int>>>()

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {

        row = m
        colum = n
        maxNum = maxMove

        for (i in 0 until row) {
            cache.add(mutableListOf())
            for (j in 0 until colum) {
                cache[i].add(mutableListOf())
                for (k in 0..maxNum) {
                    cache[i][j].add(-1)
                }
            }
        }
        return dfs(startRow,startColumn, maxMove)
    }


    fun dfs(x: Int, y:Int, k:Int): Int{
        if (x < 0 || x>= row || y < 0 || y >= colum) return 1
        if (k == 0) return 0
        if (cache[x][y][k] != -1) return cache[x][y][k]
        var ans = 0
        for (d in dirs) {
            val nx = x + d[0]
            val ny = y + d[1]
            ans += dfs(nx, ny, k -1)
            ans %= mod
        }
        cache[x][y][k] = ans
        return ans
    }
}