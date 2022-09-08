package q00

/**
 * No.8
 */
class `String to Integer (atoi)` {

    fun myAtoi(s: String): Int {
        var r: Int = 0
        var sign = 1
        var numberStarted = false

        for (c in s) {
            if (numberStarted && !c.isDigit()) {
                break
            }
            if (c == ' ') {
                continue
            }
            else if (c == '-') {
                numberStarted = true
                sign = -1
            }
            else if (c == '+') {
                numberStarted = true
                sign = 1
            }
            else if (!c.isDigit()) {
                break
            }
            else if (c.isDigit()) {
                numberStarted = true
                val d = Character.getNumericValue(c) * sign
                if ((r > Int.MAX_VALUE / 10) || (r == Int.MAX_VALUE / 10 && d > 7)) return Int.MAX_VALUE
                if ((r < Int.MIN_VALUE / 10) || (r == Int.MIN_VALUE / 10 && d < -8)) return Int.MIN_VALUE
                r = r * 10 + d
            }
        }

        return r
    }

    /**
     *
     */
    fun myAtoi1(s: String): Int {
        val (num) = "(^[-+]?\\d+)([\\s+-.\\dA-Za-z]*)".toRegex().find(s.trimStart())?.destructured ?: return 0

        val isPlus = num.first() != '-'
        return kotlin.runCatching {
            num.toInt()
        }.getOrElse {
            if (isPlus) Int.MAX_VALUE else Int.MIN_VALUE
        }
    }
}