package q00

/**
 * No.74
 */
class `Search a 2D Matrix` {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (i in 0 until matrix.size) {
            if (target <= matrix[i][matrix[i].size - 1]) {
                return findMatrix(matrix[i], target)
            }
        }

        return false
    }

    fun findMatrix(nums: IntArray, target: Int): Boolean {
        var i = 0
        var j = nums.size - 1

        while (i <= j) {
            val mid = (i + j) / 2

            if (nums[mid] == target) {
                return true
            } else if (target < nums[mid]) {
                j = mid - 1
            } else {
                i = mid + 1
            }
        }

        return false
    }

    /**
     *
     */
    fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
        var low = 0
        var hight = matrix.size * matrix[0].size - 1

        while (low <= hight) {
            val mid = (hight - low) / 2 + low
            (matrix[mid / matrix[0].size][mid % matrix[0].size]).also {
                if (it < target) {
                    low = mid + 1
                } else if(it > target) {
                    hight = mid - 1
                } else {
                    return true
                }
            }
        }

        return false
    }
}