package q00

/**
 * No.7
 */
class `Reverse Integer` {

    fun reverse(x: Int): Int {
        var isNegative = x<0
        val sb:StringBuilder  = StringBuilder()
        sb.append( x.toString())
        if(isNegative) sb.deleteCharAt(0)
        sb.reverse()

        try{ var result = Integer.parseInt(sb.toString())
            if(isNegative) result*=-1
            return result
        }catch(e:Exception){
            return 0
        }

    }

    /**
     *
     */
    fun reverse1(x: Int): Int {
        var cur = x
        var ans = 0
        while (cur != 0) {
            if (ans < Int.MIN_VALUE / 10 || ans > Int.MAX_VALUE / 10) {
                return 0
            }

            ans = ans * 10 + (cur % 10)
            cur /= 10
        }

        return ans
    }
}