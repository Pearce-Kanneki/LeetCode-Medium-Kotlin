package q00

/**
 * No.48
 */
class `Rotate Image` {

    /**
     *
     */
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix[0].size
        val m = matrix.size

        if(n == 0 || m == 0) return

        var min = 0

        while(n-2*min-1 > 0) {
            for(i in 0 until n-2*min-1) {
                //val i = 0
                val one = matrix[min][i+min]
                val two = matrix[i+min][n-min-1]
                val three = matrix[n-min-1][n-min-1-i]
                val four = matrix[n-min-1-i][min]

                matrix[i+min][n-min-1] = one
                matrix[n-min-1][n-min-1-i] = two
                matrix[n-min-1-i][min] = three
                matrix[min][i+min] = four
                if(min == 1) println("$one, $two, $three, $four")
            }
            min++
        }
    }

    /**
     *
     */
    fun rotate1(matrix: Array<IntArray>): Unit {
        val tmp = mutableListOf<Int>()

        for (i in matrix.indices) {
            for (j in matrix.lastIndex downTo 0) {
                tmp.add(matrix[j][i])
            }
        }

        tmp.forEachIndexed { index, item ->
            matrix[index / matrix.size][index % matrix.size] = item
        }
    }
}