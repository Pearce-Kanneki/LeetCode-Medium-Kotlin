package q02

/**
 * No.200
 */
class `Number of Islands` {

    /**
     *
     */
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        var islands = 0

        // Scan entire 2d array
        for (col in 0 .. grid.size - 1) {
            for (row in 0 .. grid[col].size - 1) {
                // If we find an island, mark it and everything around it as traversed
                if (grid[col][row] == '1') {
                    islands++
                    markTraversed(grid, col, row)
                }
            }
        }

        return islands
    }

    fun markTraversed(grid: Array<CharArray>, col: Int, row: Int) {
        // If we found water, don't mark
        if (grid[col][row] == '0') {
            return
        }

        grid[col][row] = '0'
        // Check left and right of current node
        if (col - 1 > -1) {
            markTraversed(grid, col - 1 , row)
        }
        if (col + 1 < grid.size) {
            markTraversed(grid, col + 1 , row)
        }
        // Check top and bottom of current node
        if (row + 1 < grid[col].size) {
            markTraversed(grid, col, row + 1)
        }
        if (row - 1 > -1) {
            markTraversed(grid, col, row - 1)
        }
    }

    /**
     *
     */
    fun numIslands1(grid: Array<CharArray>): Int {
        var ans = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '0') continue
                setZero(grid, i, j)
                ans++
            }
        }

        return ans
    }

    private fun setZero(grid: Array<CharArray>, x: Int, y: Int) {
        if (grid[x][y] == '0') return

        grid[x][y] = '0'
        if (x + 1 < grid.size) setZero(grid, x + 1, y)
        if (x - 1 >= 0) setZero(grid, x - 1, y)
        if (y + 1< grid[x].size) setZero(grid, x, y + 1)
        if (y - 1 >= 0) setZero(grid, x, y - 1)
    }
}