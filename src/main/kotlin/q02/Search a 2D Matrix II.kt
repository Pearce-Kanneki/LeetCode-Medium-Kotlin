package q02

/**
 * No.240
 */
class `Search a 2D Matrix II` {

    /**
     * 較快的解
     */
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var r = 0
        var c = matrix[0].lastIndex

        while (r in matrix.indices && c in matrix[0].indices) {
            when {
                target < matrix[r][c] -> c--
                target > matrix[r][c] -> r++
                else -> return true
            }
        }

        return false
    }

    /**
     *
     */
    fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {

        if (matrix.isEmpty()){
            return false
        }
        if (matrix[0].isNotEmpty() && matrix[0][0] > target){
            return false
        }
        if (matrix[matrix.size - 1].isNotEmpty() && matrix[matrix.size-1][matrix[matrix.size-1].size-1] < target){
            return false
        }
        for (i in matrix.indices){
            if (matrix[i].isEmpty()){
                continue
            }
            if (matrix[i][0] == target || matrix[i][matrix[i].size-1] == target){
                return true
            }
            if (matrix[i][0] < target && matrix[i][matrix[i].size-1] > target){
                if (matrix[i].contains(target)){
                    return true
                }
            }
        }
        return false
    }
}