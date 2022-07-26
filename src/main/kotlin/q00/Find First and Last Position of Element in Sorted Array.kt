package q00

/**
 * No.34
 */
class `Find First and Last Position of Element in Sorted Array` {

    fun searchRange(nums: IntArray, target: Int): IntArray {

        return intArrayOf(find(nums, target), find(nums, target, false))
    }

    private fun find(nums: IntArray, target: Int, first: Boolean = true): Int {
        var left = 0
        var right = nums.lastIndex

        while(left <= right) {
            val m = left + (right - left) / 2
            when {
                target < nums[m] -> right = m - 1
                target > nums[m] -> left = m + 1
                else -> if (first) {
                    right = if (m - 1 in nums.indices && nums[m - 1] == target) m - 1 else return m
                } else {
                    left = if (m + 1 in nums.indices && nums[m + 1] == target) m + 1 else return m
                }
            }
        }
        return -1
    }
}