package q03

/**
 * No.393
 */
class `UTF-8 Validation` {

    fun validUtf8(data: IntArray): Boolean {
        var i = 0
        while (i < data.size) {
            var j = 7
            while (j >= 0 && ((data[i] ushr j) and 1) == 1)
                j--

            val cnt = 7 - j
            if (cnt == 1 || cnt > 4) return false
            if (i + cnt - 1 > data.size) return false
            for (k in (i + 1) until (i + cnt)) {
                if (((data[k] ushr 7) and 1) == 1 && ((data[k] ushr 6) and 1) == 0)
                    continue
                return false
            }

            if (cnt == 0) i++ else i += cnt
        }

        return true
    }
}