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

fun main() {
    val solution = RotateArray()

    // Test 1: Example 1 from problem
    val nums1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
//   k = 12 val nums1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val expected1 = intArrayOf(5, 6, 7, 1, 2, 3, 4)
    solution.rotate(nums1, 3)
    println("Test 1: Expected ${expected1.contentToString()}, Got ${nums1.contentToString()} - ${if (nums1.contentEquals(expected1)) "PASS" else "FAIL"}")

    // Test 2: Example 2 from problem
    val nums2 = intArrayOf(-1, -100, 3, 99)
    val expected2 = intArrayOf(3, 99, -1, -100)
    solution.rotate(nums2, 2)
    println("Test 2: Expected ${expected2.contentToString()}, Got ${nums2.contentToString()} - ${if (nums2.contentEquals(expected2)) "PASS" else "FAIL"}")

    // Test 3: Single element with k > array size
    val nums3 = intArrayOf(-1)
    val expected3 = intArrayOf(-1)
    solution.rotate(nums3, 2)
    println("Test 3: Expected ${expected3.contentToString()}, Got ${nums3.contentToString()} - ${if (nums3.contentEquals(expected3)) "PASS" else "FAIL"}")
}