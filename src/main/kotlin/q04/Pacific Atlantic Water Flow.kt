package q04

/**
 * No.417
 */
class `Pacific Atlantic Water Flow` {

    var directuins = arrayOf(
        intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0, -1)
    )
    lateinit var grid: Array<IntArray>

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {

        val ans = arrayListOf<List<Int>>()
        grid = heights

        val pacificGrid = Array(grid.size) {
            BooleanArray(grid[0].size) { false }
        }

        val atlanticGrid = Array(grid.size) {
            BooleanArray(grid[0].size) { false }
        }

        for (i in grid.indices) {
            dfs(pacificGrid, grid, i, 0, -1)
            dfs(atlanticGrid, grid, i, grid[0].lastIndex, -1)
        }

        for (i in grid[0].indices) {
            dfs(pacificGrid, grid, 0, i, -1)
            dfs(atlanticGrid, grid, grid.lastIndex, i, -1)
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (pacificGrid[i][j] && atlanticGrid[i][j]){
                    ans.add(listOf(i, j))
                }
            }
        }

        return ans
    }

    private fun dfs(currentGrid: Array<BooleanArray>, land: Array<IntArray>, i: Int, j: Int, pre: Int) {
        if (isOutOfBounds(land, i, j)) return
        if (land[i][j] < pre) return
        if (currentGrid[i][j]) return

        currentGrid[i][j] = true
        directuins.forEach {
            dfs(currentGrid, land, i + it[0], j + it[1], land[i][j])
        }
    }

    private fun isOutOfBounds(land: Array<IntArray>, i: Int, j:Int): Boolean {
        return i < 0 || j < 0 || i > land.lastIndex || j > land[0].lastIndex
    }
}