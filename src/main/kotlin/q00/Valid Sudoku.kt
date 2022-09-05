package q00

/**
 * No.26
 */
class `Valid Sudoku` {

    /**
     *
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val gridSize = board.size
        val numCountCache = IntArray(gridSize)

        return isValidHorizontal(board,gridSize, numCountCache) && isValidVertical(board, gridSize, numCountCache) && isValidSubGrid(board, gridSize, numCountCache)


    }

    private fun isValidHorizontal(board : Array<CharArray>, gridSize : Int, countCache : IntArray) : Boolean {
        countCache.zeroFill()
        for (x in 0..gridSize - 1) {
            for (y in 0..gridSize - 1) {
                val number = if (board[x][y] != '.') {
                    board[x][y] - '0' - 1
                } else {
                    continue
                }

                countCache[number] = countCache[number] + 1

                if (countCache[number] > 1) {
                    return false
                }

            }
            countCache.zeroFill()
        }

        return true
    }

    private fun isValidVertical(board : Array<CharArray>, gridSize : Int, countCache : IntArray) : Boolean {
        countCache.zeroFill()
        for (x in 0..gridSize - 1) {
            for (y in 0..gridSize - 1) {
                val number = if (board[y][x] != '.') {
                    board[y][x] - '0' - 1
                } else {
                    continue
                }

                countCache[number] = countCache[number] + 1

                if (countCache[number] > 1) {
                    return false
                }

            }
            countCache.zeroFill()
        }

        return true
    }

    private fun isValidSubGrid(board: Array<CharArray>, gridSize : Int, countCache : IntArray) : Boolean {
        val subGridSize = 3//Math.sqrt(gridSize.toDouble()).toInt()

        for (x in 0..board.size - 1) {
            for (y in 0..board.size - 1) {


                if (x % subGridSize == 0 && y % subGridSize == 0) {
                    countCache.zeroFill()
                    // (x,y) is the top left corner of an subGridSize x subGridSize array

                    for (subGridX in x..(x + subGridSize - 1)) {
                        for (subGridY in y..(y + subGridSize - 1)) {
                            val number = if (board[subGridX][subGridY] != '.') {
                                board[subGridX][subGridY] - '0' - 1
                            } else {
                                continue
                            }

                            countCache[number] = countCache[number] + 1
                            if (countCache[number] > 1) {
                                return false
                            }
                        }
                    }
                }

            }
        }

        return true

    }

    private fun IntArray.zeroFill() {
        for (x in 0..this.size - 1) {
            this[x] = 0
        }
    }

    /**
     *
     */
    fun isValidSudoku1(board: Array<CharArray>): Boolean {

        board.forEachIndexed { index, chars ->
            chars.forEachIndexed { charIndex, item ->
                if (index == 0) {
                    val check = IntArray(9) {0}
                    repeat(9) {
                        if (board[it][charIndex] != '.' && ++check[board[it][charIndex] - '1'] > 1)
                            return false
                    }
                }
                if (charIndex == 0) {
                    val check = IntArray(9) {0}
                    for (i in chars) {
                        if (i != '.' && ++check[i - '1'] > 1)
                            return false
                    }
                }
                if (index % 3 == 0 && charIndex % 3 == 0) {
                    val check = IntArray(9) {0}
                    repeat(3){ x ->
                        repeat(3) {y ->
                            if (board[index + x][ charIndex + y] != '.' && ++check[board[index + x][ charIndex + y]- '1'] > 1)
                                return false
                        }
                    }

                }
            }
        }

        return true
    }
}