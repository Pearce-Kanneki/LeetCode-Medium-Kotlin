package q16

/**
 * No.1630
 */
class `Arithmetic Subarrays` {

    /**
     * 
     */
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {

        val result : MutableList<Boolean> = mutableListOf()

        for(idx in 0..l.lastIndex) {
            //Get subsequence
            val subsequence = nums.copyOfRange(l[idx], r[idx]+1)
            //Sort it
            subsequence.sort()
            //Check if arithmetic
            result.add(isArithmetic(subsequence))
        }
        return result.toList()
    }

    fun isArithmetic(nums: IntArray) : Boolean {
        val gap = nums[1] - nums[0]

        for(idx in 2..nums.lastIndex) {
            if(nums[idx] - nums[idx-1] != gap)
                return false
        }
        return true
    }

    /**
     *
     */
    fun checkArithmeticSubarrays1(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val ans = mutableListOf<Boolean>()
        val mNums = nums.toMutableList()

        for (i in l.indices) {
            ans.add(isSequence(mNums, l[i], r[i]))
        }

        return ans
    }

    private fun isSequence(nums: MutableList<Int>, i:Int, j: Int): Boolean {
        val nums = nums.subList(i, j + 1).sorted()
        val diff = nums[1] - nums[0]

        for (k in 2 until nums.size) {
            if (nums[k] - nums[k - 1] != diff)
                return false
        }

        return true
    }
}