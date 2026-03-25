package twopointers

import kotlin.math.exp

/**
 * 283. Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * The operation must be done in-place without making a copy of the array.
 *
 * Example 1:
 *   Input:  nums = [0, 1, 0, 3, 12]
 *   Output: [1, 3, 12, 0, 0]
 *
 * Example 2:
 *   Input:  nums = [0]
 *   Output: [0]
 *
 * Constraints:
 *   1 <= nums.length <= 10^4
 *   -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow-up: Could you minimize the total number of operations done?
 *
 * @see <a href="https://leetcode.com/problems/move-zeroes/">LeetCode 283</a>
 * Complexity: O(n) time, O(1) space — in-place single pass
 */
class MoveZeroes {
    fun moveZeroes(nums: IntArray) {
        if (nums.isEmpty()) return
        var left = 0

        for(right in 1 ..< nums.size) {
            if (nums[left] != 0) {
                left++
                continue
            }

            // nums[Left] == 0 at this point
            if (nums[right] != 0) { // Must swap
                nums[left] = nums[right]
                nums[right] = 0
                left++
            }
        }
    }
}
