package q03

/**
 * No.304
 */
class `Range Sum Query 2D - Immutable` {
}

class NumMatrix(matrix: Array<IntArray>) {

    private val row = matrix.size
    private val cols = if (row > 0) matrix[0].size else 0
    private val prefixSum = Array(row + 1){ IntArray(cols + 1) }

    init {
        for (i in 1 until prefixSum.size) {
            for (j in 1 until prefixSum[0].size) {
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i - 1][j]-
                        prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return prefixSum[row2 + 1][col2 + 1] + prefixSum[row1][col1] -
                prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1]
    }

}