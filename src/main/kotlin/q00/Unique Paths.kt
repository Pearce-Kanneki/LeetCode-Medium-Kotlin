package q00

/**
 * No.62
 */
class `Unique Paths` {

    fun uniquePaths(m: Int, n: Int): Int {

        val result = List<IntArray>(m){ IntArray(n){ 0 } }
        for (i in 0 until m) {
            result[i][0] = 1
            for (j in 0 until n) {
                if (i == 0) result[i][j] = 1
                else if (j > 0){
                    result[i][j] = result[i - 1][j] + result[i][j - 1]
                }
            }
        }

        return result[m - 1][n - 1]
    }
}