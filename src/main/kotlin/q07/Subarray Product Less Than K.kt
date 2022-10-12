package q07

/**
 * No.713
 */
class `Subarray Product Less Than K` {

    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {

        var ret = 0
        var prod = 1
        var index = 0
        nums.forEachIndexed { ii, it ->
            prod *= it
            while (index <= ii && prod >= k){
                prod /= nums[index]
                index++
            }
            ret += ii - index + 1
        }

        return ret
    }
}