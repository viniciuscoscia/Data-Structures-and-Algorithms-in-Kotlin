package slidingwindow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSizeSubarraySumTest {

    private val solution = MinimumSizeSubarraySum()

    @Test
    fun `example 1 - subarray of length 2 satisfies target`() {
        val nums = intArrayOf(2, 3, 1, 2, 4, 3)
        val target = 7
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 2 | Got: $result")
        assertEquals(2, result)
    }

    @Test
    fun `example 2 - single element equals target`() {
        val nums = intArrayOf(1, 4, 4)
        val target = 4
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `example 3 - no subarray reaches target, return 0`() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)
        val target = 11
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 0 | Got: $result")
        assertEquals(0, result)
    }

    @Test
    fun `single element greater than target returns 1`() {
        val nums = intArrayOf(10)
        val target = 5
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `single element equal to target returns 1`() {
        val nums = intArrayOf(7)
        val target = 7
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `single element less than target returns 0`() {
        val nums = intArrayOf(3)
        val target = 7
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 0 | Got: $result")
        assertEquals(0, result)
    }

    @Test
    fun `entire array needed to reach target`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val target = 10
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 4 | Got: $result")
        assertEquals(4, result)
    }

    @Test
    fun `multiple valid subarrays returns shortest`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val target = 9
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 2 | Got: $result")
        assertEquals(2, result)
    }

    @Test
    fun `target met at the start of the array`() {
        val nums = intArrayOf(5, 1, 1, 1, 1)
        val target = 5
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `target met at the end of the array`() {
        val nums = intArrayOf(1, 1, 1, 1, 5)
        val target = 5
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `sum of entire array equals target exactly`() {
        val nums = intArrayOf(1, 2, 3)
        val target = 6
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 3 | Got: $result")
        assertEquals(3, result)
    }

    @Test
    fun `target is 1 and all elements are 1 returns 1`() {
        val nums = intArrayOf(1, 1, 1, 1)
        val target = 1
        val result = solution.minSubArrayLen(target, nums)
        println("Input: target=$target, nums=${nums.contentToString()}")
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }
}