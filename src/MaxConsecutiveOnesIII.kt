/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 * Complexity: O(n) time, O(1) space
 */

class MaxConsecutiveOnesIII {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var leftIndex = 0
        var rightIndex = 0
        var zeroes = 0
        var count = 0
        var max = 0

        while (rightIndex < nums.size) {
            // We need to advance and start counting the zeroes
            val currentValue = nums[rightIndex]
            if (currentValue == 0) {
                zeroes++
            }
            rightIndex++
            count++
            while (zeroes > k) {
                val leftValue = nums[leftIndex]
                if (leftValue == 0) {
                    zeroes--
                }
                count--
                leftIndex++
            }
            if (count > max) {
                max = count
            }
        }
        return max
    }
}

fun testExample1() {
    val maxConsecutiveOnesIII = MaxConsecutiveOnesIII()
    val nums = intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0)
    val k = 2
    val result = maxConsecutiveOnesIII.longestOnes(nums = nums, k = k)
    println("Test Example 1: Expected 6, Got $result - ${if (result == 6) "PASS" else "FAIL"}")
}

fun testExample2() {
    val maxConsecutiveOnesIII = MaxConsecutiveOnesIII()
    val nums = intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1)
    val k = 3
    val result = maxConsecutiveOnesIII.longestOnes(nums = nums, k = k)
    println("Test Example 2: Expected 10, Got $result - ${if (result == 10) "PASS" else "FAIL"}")
}

fun testAllOnes() {
    val maxConsecutiveOnesIII = MaxConsecutiveOnesIII()
    val nums = intArrayOf(1, 1, 1, 1, 1)
    val k = 0
    val result = maxConsecutiveOnesIII.longestOnes(nums = nums, k = k)
    println("Test All Ones: Expected 5, Got $result - ${if (result == 5) "PASS" else "FAIL"}")
}

fun testAllZeroes() {
    val maxConsecutiveOnesIII = MaxConsecutiveOnesIII()
    val nums = intArrayOf(0, 0, 0, 0, 0)
    val k = 2
    val result = maxConsecutiveOnesIII.longestOnes(nums = nums, k = k)
    println("Test All Zeroes: Expected 2, Got $result - ${if (result == 2) "PASS" else "FAIL"}")
}

fun testNoFlips() {
    val maxConsecutiveOnesIII = MaxConsecutiveOnesIII()
    val nums = intArrayOf(1, 0, 1, 0, 1)
    val k = 0
    val result = maxConsecutiveOnesIII.longestOnes(nums = nums, k = k)
    println("Test No Flips: Expected 1, Got $result - ${if (result == 1) "PASS" else "FAIL"}")
}

fun main() {
    testExample1()
    testExample2()
    testAllOnes()
    testAllZeroes()
    testNoFlips()
}