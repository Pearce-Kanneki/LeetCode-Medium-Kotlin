package q09

/**
 * No.916
 */
class `Word Subsets` {

    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val bmax = count("")
        words2.forEach {
            val bCount = count(it)
            for (i in 0 until 26) {
                bmax[i] = maxOf(bmax[i], bCount[i])
            }
        }

        val ans = mutableListOf<String>()
        loop@ for (i in words1.indices) {
            val aCount = count(words1[i])
            for (i in 0 until 26){
                if (aCount[i] < bmax[i]) continue@loop
            }
            ans.add(words1[i])
        }

        return ans
    }

    fun count(s: String):IntArray {
        val ans = IntArray(26){0}
        s.forEach {
            ans[it - 'a']++
        }

        return ans
    }
}