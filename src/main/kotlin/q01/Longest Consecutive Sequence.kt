package q01

/**
 * No.128
 */
class `Longest Consecutive Sequence` {

    fun longestConsecutive(nums: IntArray): Int {

        if (nums.isEmpty()) return 0
        var result = 0
        var count = 1
        nums.sort()
        nums.forEachIndexed { index, item ->
            if (index > 0 && item - nums[index - 1] == 1) {
                count++
            } else if(index > 0 && item != nums[index - 1]){
                count = 1
            }

            result = maxOf(result, count)
        }

        return result
    }
}