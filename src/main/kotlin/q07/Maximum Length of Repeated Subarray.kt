package q07

/**
 * No.718
 */
class `Maximum Length of Repeated Subarray` {

    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val len1 = nums1.size
        val len2 = nums2.size
        var ans = 0
        nums1.forEachIndexed { index, _ ->
            val len = Math.min(len2, len1 - index)
            val maxLen = maxLength(nums1, nums2, index, 0, len)
            if (maxLen > ans) ans = maxLen
        }
        nums2.forEachIndexed { index, _ ->
            val len = Math.min(len1, len2 - index)
            val maxLen = maxLength(nums1, nums2, 0, index, len)
            if (maxLen > ans) ans = maxLen
        }

        return ans
    }

    private fun maxLength(a: IntArray, b: IntArray, addA: Int, addB: Int, len: Int): Int {
        var ret = 0
        var k = 0
        for (i in 0 until len) {
            if (a[addA + i] == b[addB + i]) k++ else k = 0
            if (k > ret) ret = k
        }

        return ret
    }
}