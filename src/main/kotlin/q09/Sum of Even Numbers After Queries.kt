package q09

/**
 * NO.985
 */
class `Sum of Even Numbers After Queries` {

    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {

        var s = 0
        nums.forEach {
            if (it % 2 == 0) s+= it
        }

        val ans = IntArray(queries.size)

        queries.forEachIndexed { i, ints ->
            val v = ints[0]
            val index = ints[1]

            if (nums[index] % 2 == 0)
                s -= nums[index]
            nums[index] += v
            if (nums[index] % 2 == 0)
                s += nums[index]

            ans[i] = s
        }

        return ans
    }
}