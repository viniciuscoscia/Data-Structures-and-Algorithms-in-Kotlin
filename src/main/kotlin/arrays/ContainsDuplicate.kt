package arrays

/**
 * 217. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation: The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation: All elements are distinct.
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
class ContainsDuplicate {

    // HashSet — O(n) time, O(n) space
    fun containsDuplicate(nums: IntArray): Boolean {
        val seen = mutableSetOf<Int>()
        for (num in nums) {
            if (num in seen) return true
            seen.add(num)
        }
        return false
    }

    // Sort + adjacent check — O(n log n) time, O(1) space
    fun containsDuplicateSorting(nums: IntArray): Boolean {
        nums.sort()
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) return true
        }
        return false
    }
}
