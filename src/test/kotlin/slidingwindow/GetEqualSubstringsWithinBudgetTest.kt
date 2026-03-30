package slidingwindow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetEqualSubstringsWithinBudgetTest {

    private val solution = GetEqualSubstringsWithinBudget()

    @Test
    fun `example 1 returns 3`() {
        val s = "abcd"
        val t = "bcdf"
        val maxCost = 3
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 3 | Got: $result")
        assertEquals(3, result)
    }

    @Test
    fun `example 2 each char costs 2 returns 1`() {
        val s = "abcd"
        val t = "cdef"
        val maxCost = 3
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `example 3 maxCost zero with one free char returns 1`() {
        val s = "abcd"
        val t = "acde"
        val maxCost = 0
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `identical strings with maxCost zero returns full length`() {
        val s = "abcd"
        val t = "abcd"
        val maxCost = 0
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 4 | Got: $result")
        assertEquals(4, result)
    }

    @Test
    fun `maxCost covers entire string returns full length`() {
        val s = "abcd"
        val t = "bcde"
        val maxCost = 4
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 4 | Got: $result")
        assertEquals(4, result)
    }

    @Test
    fun `maxCost zero and all chars differ returns 0`() {
        val s = "abcd"
        val t = "efgh"
        val maxCost = 0
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 0 | Got: $result")
        assertEquals(0, result)
    }

    @Test
    fun `single character strings that match returns 1`() {
        val s = "a"
        val t = "a"
        val maxCost = 0
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `single character strings that differ with zero budget returns 0`() {
        val s = "a"
        val t = "z"
        val maxCost = 0
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 0 | Got: $result")
        assertEquals(0, result)
    }

    @Test
    fun `best window is in the middle of the string`() {
        val s = "aabcd"
        val t = "zzbcd"
        val maxCost = 3
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 3 | Got: $result")
        assertEquals(3, result)
    }

    @Test
    fun `best window is at the end of the string`() {
        val s = "zzzabc"
        val t = "aaabcd"
        val maxCost = 3
        println("Input: s=\"$s\", t=\"$t\", maxCost=$maxCost")
        val result = solution.equalSubstring(s, t, maxCost)
        println("Expected: 3 | Got: $result")
        assertEquals(3, result)
    }
}
