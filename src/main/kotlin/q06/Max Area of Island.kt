package q06

/**
 * No.695
 */
class `Max Area of Island` {

    /**
     * 較快的解
     */
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {

        val visited = Array(grid.size) { BooleanArray(grid[it].size) }
        val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

        fun size(row: Int, col: Int): Int {
            if (row !in grid.indices || col !in grid[row].indices) return 0
            if (visited[row][col] || grid[row][col] == 0) return 0

            visited[row][col] = true

            var res = 1
            for ((r, c) in directions) {
                res += size(row + r, col + c)
            }

            return res
        }

        var res = 0

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                res = maxOf(res, size(row, col))
            }
        }

        return res
    }
    /**
     *
     */
    fun maxAreaOfIsland1(grid: Array<IntArray>): Int {

        var maxNum = 0
        grid.forEachIndexed { index, ints ->
            ints.forEachIndexed { iindex, item ->
                if (item == 1) {
                    maxNum = maxOf(maxNum, dfs(grid, index, iindex))
                }
            }
        }

        return maxNum
    }

    private fun dfs(grid: Array<IntArray>, i: Int, j: Int): Int {

        if (i < 0 || i >= grid.size) return 0
        if (j < 0 || j >= grid[i].size) return 0
        if (grid[i][j] == 0) return 0

        grid[i][j] = 0
        var sum = 1
        sum += dfs(grid, i + 1, j)
        sum += dfs(grid, i - 1, j)
        sum += dfs(grid, i , j + 1)
        sum += dfs(grid, i, j - 1)

        return sum
    }
}