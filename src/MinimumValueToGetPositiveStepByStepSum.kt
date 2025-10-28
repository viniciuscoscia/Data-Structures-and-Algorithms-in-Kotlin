/**
 * Minimum Value to Get Positive Step by Step Sum
 *
 * Given an array of integers nums, you start with an initial positive value startValue.
 *
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
 *
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 *
 * Example 1:
 * Input: nums = [-3,2,-3,4,2]
 * Output: 5
 * Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
 * ```
 * step by step sum
 * startValue = 4 | startValue = 5 | nums
 *   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 *   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 *   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 *   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 *   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * ```
 *
 * Example 2:
 * Input: nums = [1,2]
 * Output: 1
 * Explanation: Minimum start value should be positive.
 *
 * Example 3:
 * Input: nums = [1,-2,-3]
 * Output: 5
 */
class MinimumValueToGetPositiveStepByStepSum {
    fun minStartValue(nums: IntArray): Int {
        var sum = 0
        var minValue = 0

        for (num in nums) {
            sum += num
            minValue = minOf(minValue, sum)
        }

        return -minValue + 1
    }
}

fun main() {
    val solution = MinimumValueToGetPositiveStepByStepSum()

    // Test case 1: Example 1 from problem description
    val result1 = solution.minStartValue(nums = intArrayOf(-3, 2, -3, 4, 2))
    println("Test 1: Expected 5, Got $result1 - ${if (result1 == 5) "PASS" else "FAIL"}")

    // Test case 2: Example 2 from problem description
    val result2 = solution.minStartValue(nums = intArrayOf(1, 2))
    println("Test 2: Expected 1, Got $result2 - ${if (result2 == 1) "PASS" else "FAIL"}")

    // Test case 3: Example 3 from problem description
    val result3 = solution.minStartValue(nums = intArrayOf(1, -2, -3))
    println("Test 3: Expected 5, Got $result3 - ${if (result3 == 5) "PASS" else "FAIL"}")

    // Test case 4: All positive numbers
    val result4 = solution.minStartValue(nums = intArrayOf(1, 2, 3, 4))
    println("Test 4: Expected 1, Got $result4 - ${if (result4 == 1) "PASS" else "FAIL"}")

    // Test case 5: Single negative number
    val result5 = solution.minStartValue(nums = intArrayOf(-5))
    println("Test 5: Expected 6, Got $result5 - ${if (result5 == 6) "PASS" else "FAIL"}")

    // Test case 6: Large negative sum
    val result6 = solution.minStartValue(nums = intArrayOf(-10, 5, -8, 3))
    println("Test 6: Expected 11, Got $result6 - ${if (result6 == 11) "PASS" else "FAIL"}")
}

