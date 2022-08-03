package q03

/**
 * No.307
 */
class `Range Sum Query - Mutable`(nums: IntArray) {

    val nums = nums

    fun update(index: Int, `val`: Int) {
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int {
        var count = 0
        for (i in left..right) {
            count += nums[i]
        }

        return count
    }
}