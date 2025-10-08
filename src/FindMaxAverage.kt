/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * Example 2:
 *
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 */

class FindMaxAverage {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        if (k > nums.size) {
            return 0.0
        }

        var startIndex = 0
        var endIndex = 0
        var sum = 0.0

        while(endIndex < k) {
            sum += nums[endIndex]
            endIndex++
        }

        var average: Double = sum/k

        while (endIndex < nums.size - 1) {
            sum -= nums[startIndex]
            startIndex++
            sum += nums[endIndex]
            endIndex++
            val currentAverage = sum /k
            if (currentAverage > average) {
                average = currentAverage
            }
        }

        return average
    }
}

fun main() {
    val solution = FindMaxAverage()

    // Test case 1: Example from problem
    val result1 = solution.findMaxAverage(nums = intArrayOf(1, 12, -5, -6, 50, 3), k = 4)
    println("Test 1: Expected 12.75000, Got $result1")

    // Test case 2: Single element
    val result2 = solution.findMaxAverage(nums = intArrayOf(5), k = 1)
    println("Test 2: Expected 5.00000, Got $result2")

    // Test case 3: All same elements
    val result3 = solution.findMaxAverage(nums = intArrayOf(3, 3, 3, 3, 3), k = 3)
    println("Test 3: Expected 3.00000, Got $result3")

    // Test case 4: Negative numbers
    val result4 = solution.findMaxAverage(nums = intArrayOf(-1, -2, -3, -4, -5), k = 2)
    println("Test 4: Expected -1.50000, Got $result4")

    // Test case 5: k equals array length
    val result5 = solution.findMaxAverage(nums = intArrayOf(1, 2, 3, 4), k = 4)
    println("Test 5: Expected 2.50000, Got $result5")
}