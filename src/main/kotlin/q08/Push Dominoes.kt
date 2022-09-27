package q08

/**
 * No.838
 */
class `Push Dominoes` {

    fun pushDominoes(dominoes: String): String {
        val mDominoes = "L" + dominoes + "R"
        var l = 0
        val ans = StringBuilder()

        for (i in 1 until mDominoes.length) {
            if (mDominoes[i] == '.') continue

            if (l != 0) ans.append(mDominoes[l])
            val mid = i - l - 1

            if (mDominoes[l] == mDominoes[i]) {

                for (j in 0 until mid)
                    ans.append(mDominoes[l])
            } else if (mDominoes[l] == 'L' && mDominoes[i] == 'R') {

                for (j in 0 until mid)
                    ans.append('.')
            } else {

                for (j in 0 until (mid / 2))
                    ans.append('R')

                if (mid % 2 == 1) ans.append('.')

                for (j in 0 until (mid / 2))
                    ans.append('L')
            }
            l = i
        }

        return ans.toString()
    }
}