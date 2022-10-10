package q00

/**
 * NNo.16
 */
class `3Sum Closest` {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size == 3) return nums.sum()

        nums.sort()
        val n = nums.size
        var best = Int.MAX_VALUE

        for (i in 0 until n) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue

            var j = i + 1
            var k = n - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                if (sum == target) return target

                if (Math.abs(sum - target) < Math.abs(best - target))
                    best = sum

                if (sum > target) {
                    var k0 = k - 1
                    while (j < k0 && nums[k0] == nums[k])
                        k0--

                    k = k0
                } else {
                    var j0 = j + 1
                    while (j0 < k && nums[j0] == nums[j])
                        j0++

                    j = j0
                }
            }
        }

        return best
    }
}