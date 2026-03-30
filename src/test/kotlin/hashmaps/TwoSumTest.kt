package hashmaps

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumTest {

    private val solution = TwoSum()

    @Test
    fun `two numbers at start sum to target`() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expected = intArrayOf(0, 1)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }

    @Test
    fun `two numbers not at start sum to target`() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expected = intArrayOf(1, 2)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }

    @Test
    fun `duplicate values sum to target`() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expected = intArrayOf(0, 1)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }

    @Test
    fun `negative numbers sum to target`() {
        val nums = intArrayOf(-3, 4, 3, 90)
        val target = 0
        val expected = intArrayOf(0, 2)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }

    @Test
    fun `negative target with negative numbers`() {
        val nums = intArrayOf(-1, -2, -3, -4)
        val target = -6
        val expected = intArrayOf(1, 3)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }

    @Test
    fun `answer is at the end of the array`() {
        val nums = intArrayOf(1, 3, 5, 7, 9, 2)
        val target = 11
        val expected = intArrayOf(4, 5)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }

    @Test
    fun `zero and non-zero number sum to target`() {
        val nums = intArrayOf(0, 4, 3, 0)
        val target = 0
        val expected = intArrayOf(0, 3)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }

    @Test
    fun `large values sum to target`() {
        val nums = intArrayOf(1_000_000_000, -1_000_000_000, 500_000_000, -500_000_000)
        val target = 0
        val expected = intArrayOf(0, 1)
        println("Input: nums=${nums.contentToString()}, target=$target")
        val result = solution.twoSum(nums, target)
        println("Expected: ${expected.contentToString()} | Got: ${result.contentToString()}")
        assertArrayEquals(expected, result)
    }
}
