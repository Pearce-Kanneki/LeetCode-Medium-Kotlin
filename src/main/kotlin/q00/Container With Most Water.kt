package q00

/**
 * No.11
 */
class `Container With Most Water` {

    fun maxArea(height: IntArray): Int {

        var ans = 0
        var left = 0
        var right = height.lastIndex

        while (left < right) {
            val area = minOf(height[left], height[right]) * (right - left)
            ans = maxOf(ans, area)

            if (height[left] <= height[right]) left++ else right--
        }

        return ans
    }
}