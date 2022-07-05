package q03

/**
 * No.376
 */
class `Wiggle Subsequence` {

    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size <= 1) {
            return nums.size
        }

        var answer = 1
        var prevDiff = 0

        for (i in 1 until nums.size) {
            val diff = nums[i-1] - nums[i]

            if ((prevDiff >= 0 && diff < 0) || (prevDiff <= 0 && diff > 0)) {
                answer++
                prevDiff = diff
            }
        }

        return answer
    }

    fun wiggleMaxLength1(nums: IntArray): Int {

        var upSum = 1
        var downSum = 1
        nums.forEachIndexed { index, item ->

            if (index > 0 && item > nums[index - 1]) {
                upSum = downSum + 1
            } else if (index > 0 && item < nums[index - 1]) {
                downSum = upSum + 1
            }
        }

        return maxOf(upSum, downSum)
    }
}