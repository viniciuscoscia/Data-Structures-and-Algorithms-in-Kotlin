package slidingwindow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaxAverageTest {

    private val solution = FindMaxAverage()

    @Test
    fun `example from problem returns 12 75`() {
        assertEquals(12.75, solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4), 1e-5)
    }

    @Test
    fun `single element returns that element`() {
        assertEquals(5.0, solution.findMaxAverage(intArrayOf(5), 1), 1e-5)
    }

    @Test
    fun `all same elements returns that element`() {
        assertEquals(3.0, solution.findMaxAverage(intArrayOf(3, 3, 3, 3, 3), 3), 1e-5)
    }

    @Test
    fun `all negative numbers returns least negative average`() {
        assertEquals(-1.5, solution.findMaxAverage(intArrayOf(-1, -2, -3, -4, -5), 2), 1e-5)
    }

    @Test
    fun `k equals array length returns overall average`() {
        assertEquals(2.5, solution.findMaxAverage(intArrayOf(1, 2, 3, 4), 4), 1e-5)
    }

    // The following tests expose the off-by-one bug: the last window is never evaluated
    // when the condition is `endIndex < nums.size - 1` instead of `endIndex < nums.size`.

    @Test
    fun `max average window is the last window k equals 1`() {
        // Last element (100) is the max; bug returns 1.0 instead of 100.0
        val nums = intArrayOf(1, 1, 100)
        println("Input: ${nums.contentToString()}, k=1")
        val result = solution.findMaxAverage(nums, 1)
        println("Expected: 100.0 | Got: $result")
        assertEquals(100.0, result, 1e-5)
    }

    @Test
    fun `max average window is the last window k equals 2`() {
        // Last window [90, 100] has avg 95; bug never evaluates it and returns 5.0
        val nums = intArrayOf(1, 9, 90, 100)
        println("Input: ${nums.contentToString()}, k=2")
        val result = solution.findMaxAverage(nums, 2)
        println("Expected: 95.0 | Got: $result")
        assertEquals(95.0, result, 1e-5)
    }

    @Test
    fun `max average window is exactly the last two elements`() {
        // Windows: [1,2]=1.5, [2,3]=2.5, [3,100]=51.5 — last window wins; bug misses it
        val nums = intArrayOf(1, 2, 3, 100)
        println("Input: ${nums.contentToString()}, k=2")
        val result = solution.findMaxAverage(nums, 2)
        println("Expected: 51.5 | Got: $result")
        assertEquals(51.5, result, 1e-5)
    }
}
