package q00

/**
 * No.54
 */
class `Spiral Matrix` {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix[0].isEmpty()) return emptyList()
        val ans = mutableListOf<Int>()

        var left = 0
        var right = matrix[0].lastIndex
        var top = 0
        var bottom = matrix.lastIndex

        while (left<= right && top<=bottom) {

            for (i in left..right)
                ans.add(matrix[top][i])

            for (i in (top+1)..bottom)
                ans.add(matrix[i][right])

            if (left<right && top<bottom) {
                for (i in (right-1) downTo (left + 1))
                    ans.add(matrix[bottom][i])

                for (i in bottom downTo (top+1))
                    ans.add(matrix[i][left])
            }

            left++
            right--
            top++
            bottom--
        }

        return ans
    }
}