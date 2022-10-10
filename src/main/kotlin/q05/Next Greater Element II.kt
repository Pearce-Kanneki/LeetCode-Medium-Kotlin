package q05

import java.util.*

/**
 * No.503
 */
class `Next Greater Element II` {

    fun nextGreaterElements(nums: IntArray): IntArray {
        val len = nums.size
        val ans = IntArray(len){-1}
        val stack = LinkedList<Int>()

        var idx = 0

        while (idx < len * 2){
            while (stack.isNotEmpty() && nums[idx % len] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[idx % len]
            }

            stack.push(idx % len)
            idx++
        }

        return ans
    }
}