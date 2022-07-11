package q16

/**
 * No.1696
 */
class `Jump Game VI` {

    fun maxResult(nums: IntArray, k: Int): Int {

        var result = nums[0]
        var index = 0

        while (index < nums.size) {

            val maxNumber = if (index + k >= nums.size) nums.size - index else k
            if (index + 1 < nums.size) {
                val tmpList = nums.copyOfRange(index + 1, maxNumber)
                index += tmpList.indexOf(tmpList.max() ?: tmpList[0]) + 1
                result += nums[index]
            } else {
                index = nums.size + 1
            }
        }

        return result
    }
}

fun main() {
    val s = `Jump Game VI`().maxResult(intArrayOf(1,-1,-2,4,-7,3), 2)

    println("result: $s")
}