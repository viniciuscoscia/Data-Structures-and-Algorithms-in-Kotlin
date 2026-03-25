/**
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal
 * to target. If there is no such subarray, return 0 instead.
 *
 * Constraints:
 * - 1 <= target <= 10^9
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^4
 *
 * Example 1: target = 7, nums = [2,3,1,2,4,3] → 2  ([4,3])
 * Example 2: target = 4, nums = [1,4,4]        → 1  ([4])
 * Example 3: target = 11, nums = [1,1,1,1,1,1,1,1] → 0
 */
class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLength = Int.MAX_VALUE
        var left = 0
        var sum = 0

        for (right in nums.indices) {
            sum += nums[right]
            while (sum >= target) {
                minLength = minOf(minLength, right - left + 1)
                sum -= nums[left++]
            }
        }

        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }
}

private fun minSubArrayLenLegacy(target: Int, nums: IntArray): Int {
    var minLength = Int.MAX_VALUE
    var left = 0
    var right = 0
    var sum = 0

    while(right < nums.size) {
        while (sum < target && right < nums.size) {
            sum += nums[right]
            right++
        }

        while (sum >= target) {
            val len = right - left
            if (len < minLength) {
                minLength = len
            }

            sum -= nums[left]
            left++
        }
    }

    return if (minLength == Int.MAX_VALUE) {
        0
    } else {
        minLength
    }
}