package q00

/**
 * No.6
 */
class `Zigzag Conversion` {

    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val result = StringBuffer()
        val step = 2 * numRows - 2
        var currendDebaff = 0
        repeat(numRows) { i ->
            var c = i

            if (i == 0 || i == numRows - 1) {
                while (c < s.length) {
                    result.append(s[c])
                    c += step
                }
            } else {
                var directon = true
                currendDebaff += 2
                while (c < s.length) {
                    if (directon) {
                        result.append(s[c])
                        c += step - currendDebaff
                        directon = false
                    } else {
                        result.append(s[c])
                        c += currendDebaff
                        directon = true
                    }
                }
            }
        }

        return result.toString()
    }
}