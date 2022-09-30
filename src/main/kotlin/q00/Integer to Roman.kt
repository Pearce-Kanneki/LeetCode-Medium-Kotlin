package q00

/**
 * No.12
 */
class `Integer to Roman` {

    /**
     *
     */
    fun intToRoman(num: Int): String {
        val thousands = arrayOf(
            "",
            "M", // 1000
            "MM", // 2000
            "MMM" // 3000
        )
        val hundreds = arrayOf(
            "",
            "C", // 100
            "CC", //200
            "CCC", // 300
            "CD", // 400
            "D", // 500
            "DC", // 600
            "DCC", // 700
            "DCCC", // 800
            "CM" // 900
        )
        val tens = arrayOf(
            "",
            "X", // 10
            "XX", // 20
            "XXX", // 30
            "XL", // 40
            "L",  // 50
            "LX", // 60
            "LXX", // 70
            "LXXX", // 80
            "XC" // 90
        )
        val units = arrayOf(
            "",
            "I", // 1
            "II", // 2
            "III", // 3
            "IV", // 4
            "V", // 5
            "VI", // 6
            "VII", // 7
            "VIII", // 8
            "IX" // 9
        )
        return thousands[num/1000] +
                hundreds[(num%1000)/100] +
                tens[(num%100)/10] +
                units[(num%10)]
    }

    /**
     *
     */
    fun intToRoman1(num: Int): String {
        var n = num
        val ret = StringBuffer()
        var d = 0

        val result = listOf(
            Pair("I", "V"),
            Pair("X", "L"),
            Pair("C", "D"),
            Pair("M", "M")
        )

        while (n > 0) {
            when (val check = n % 10){
                4 -> ret.append(result[d].second + result[d].first)
                9 -> ret.append(result[d + 1].first + result[d].first)
                else -> {
                    repeat(if (check >= 5) check - 5 else check) {
                        ret.append(result[d].first)
                    }

                    if (check >= 5)
                        ret.append(result[d].second)
                }
            }

            d++
            n /= 10
        }

        return ret.reverse().toString()
    }
}