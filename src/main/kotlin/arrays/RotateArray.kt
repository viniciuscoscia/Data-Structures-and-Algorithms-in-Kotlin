package arrays

/**
 * 189. Rotate Array
 *
 * Given an integer array `nums`, rotate the array to the right by `k` steps,
 * where `k` is non-negative. The rotation must be done **in-place**.
 *
 * ## Examples
 *
 * **Example 1:**
 * ```
 * Input:  nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 * Output: [5, 6, 7, 1, 2, 3, 4]
 *
 * Step-by-step:
 *   rotate 1 step  → [7, 1, 2, 3, 4, 5, 6]
 *   rotate 2 steps → [6, 7, 1, 2, 3, 4, 5]
 *   rotate 3 steps → [5, 6, 7, 1, 2, 3, 4]
 * ```
 *
 * **Example 2:**
 * ```
 * Input:  nums = [-1, -100, 3, 99], k = 2
 * Output: [3, 99, -1, -100]
 *
 * Step-by-step:
 *   rotate 1 step  → [99, -1, -100, 3]
 *   rotate 2 steps → [3, 99, -1, -100]
 * ```
 *
 * ## Constraints
 * - `1 <= nums.length <= 10⁵`
 * - `-2³¹ <= nums[i] <= 2³¹ - 1`
 * - `0 <= k <= 10⁵`
 *
 * ## Approaches
 *
 * | Approach              | Time   | Space | Method                                                    |
 * |-----------------------|--------|-------|-----------------------------------------------------------|
 * | Extra array           | O(n)   | O(n)  | Copy to new array at shifted indices                      |
 * | Cyclic replacements   | O(n)   | O(1)  | Move elements in cycles until all are placed              |
 * | Reverse three times   | O(n)   | O(1)  | Reverse all, then first k, then remaining (most elegant)  |
 * | Rotate one-by-one     | O(n*k) | O(1)  | Shift all elements right, k times (inefficient)           |
 *
 * **Key insight:** When `k >= n`, rotating `k` times is equivalent to rotating `k % n` times.
 *
 * Follow-up: Could you do it in-place with O(1) extra space?
 * → Yes, the "reverse three times" approach achieves this elegantly.
 *
 * @see <a href="https://leetcode.com/problems/rotate-array/">LeetCode 189</a>
 */
class RotateArray {
    // TODO (Rank 2) — Violates the in-place constraint: extra arrays are allocated, so space is O(n) instead of O(1).
    fun rotate(nums: IntArray, k: Int) {
        if (nums.size < 2) return // Nothing to rotate

        val rotationPoint = k % nums.size
        val splitIndex = nums.size - rotationPoint

        val left = nums.sliceArray(0 ..< splitIndex)
        val right = nums.sliceArray(splitIndex ..< nums.size)

        (right + left).forEachIndexed { index, i ->
            nums[index] = i
        }
    }
}