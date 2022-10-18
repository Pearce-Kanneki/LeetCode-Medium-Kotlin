package q00

/**
 * No.38
 */
class `Count and Say` {

    fun countAndSay(n: Int): String {
        if (n == 1) return "1"

        val previous: String = countAndSay(n - 1)
        val output = StringBuilder()

        var index = 0
        var count = 1

        while (index < previous.length) {
            while (index < previous.lastIndex && previous[index] == previous[index + 1]) {
                count++
                index++
            }

            output.append(count)
            output.append(previous[index])
            count = 1
            index++
        }

        return output.toString()

    }
}