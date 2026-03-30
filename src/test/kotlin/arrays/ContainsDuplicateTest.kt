package arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainsDuplicateTest {

    private val solution = ContainsDuplicate()

    @Test
    fun `duplicate at start and end returns true`() {
        val nums = intArrayOf(1, 2, 3, 1)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `all distinct elements returns false`() {
        val nums = intArrayOf(1, 2, 3, 4)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `multiple duplicates returns true`() {
        val nums = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `single element returns false`() {
        val nums = intArrayOf(1)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `two identical elements returns true`() {
        val nums = intArrayOf(5, 5)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `two different elements returns false`() {
        val nums = intArrayOf(1, 2)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `negative numbers with duplicate returns true`() {
        val nums = intArrayOf(-1, -2, -3, -1)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `negative numbers all distinct returns false`() {
        val nums = intArrayOf(-1, -2, -3, -4)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `duplicate is the last two elements returns true`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 5)
        println("Input: ${nums.contentToString()}")
        val result = solution.containsDuplicate(nums)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }
}
