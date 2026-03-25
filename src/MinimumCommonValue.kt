/**
 * 2540. Minimum Common Value
 *
 * Given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * return the minimum integer common to both arrays. If there is no common
 * integer amongst nums1 and nums2, return -1.
 *
 * An integer is considered common to nums1 and nums2 if both arrays have at
 * least one occurrence of that integer.
 *
 * Example 1:
 *   Input: nums1 = [1,2,3], nums2 = [2,4]
 *   Output: 2
 *   Explanation: The smallest element common to both arrays is 2.
 *
 * Example 2:
 *   Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 *   Output: 2
 *   Explanation: There are two common elements (2 and 3); 2 is the smallest.
 *
 * Constraints:
 *   1 <= nums1.length, nums2.length <= 10^5
 *   1 <= nums1[i], nums2[j] <= 10^9
 *   Both nums1 and nums2 are sorted in non-decreasing order.
 *
 * Hint: Since both arrays are sorted, consider using two pointers to traverse
 * them simultaneously without extra space. At each step, advance the pointer
 * that points to the smaller value.
 * Complexity: O(m + n) time, O(1) space — m and n are the lengths of nums1 and nums2
 */
class MinimumCommonValue {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        var p1 = 0
        var p2 = 0

        while (p1 < nums1.size && p2 < nums2.size) {
            val value1 = nums1[p1]
            val value2 = nums2[p2]
            if (value1 == value2) return value1
            if (value1 < value2) {
                p1++
            } else {
                p2++
            }
        }

        return -1
    }
}
