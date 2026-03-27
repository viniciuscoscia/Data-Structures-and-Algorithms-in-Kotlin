package slidingwindow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxVowelsInSubstringTest {

    private val solution = MaxVowelsInSubstring()

    @Test
    fun `all vowels in the middle window returns window size`() {
        val s = "abciiidef"
        val k = 3
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 3 | Got: $result")
        assertEquals(3, result)
    }

    @Test
    fun `string is all vowels returns k`() {
        val s = "aeiou"
        val k = 2
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 2 | Got: $result")
        assertEquals(2, result)
    }

    @Test
    fun `mixed string returns max vowels in any window`() {
        val s = "leetcode"
        val k = 3
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 2 | Got: $result")
        assertEquals(2, result)
    }

    @Test
    fun `no vowels in string returns zero`() {
        val s = "rhythm"
        val k = 3
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 0 | Got: $result")
        assertEquals(0, result)
    }

    @Test
    fun `k equals string length returns total vowels`() {
        val s = "aeioubc"
        val k = 7
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 5 | Got: $result")
        assertEquals(5, result)
    }

    @Test
    fun `k equals 1 returns 1 when any vowel exists`() {
        val s = "bcd"
        val k = 1
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 0 | Got: $result")
        assertEquals(0, result)
    }

    @Test
    fun `single character vowel string with k 1 returns 1`() {
        val s = "a"
        val k = 1
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 1 | Got: $result")
        assertEquals(1, result)
    }

    @Test
    fun `max vowels window is at the end of the string`() {
        val s = "bcaeiou"
        val k = 3
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 3 | Got: $result")
        assertEquals(3, result)
    }

    @Test
    fun `max vowels window is at the start of the string`() {
        val s = "aeiobcd"
        val k = 3
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 3 | Got: $result")
        assertEquals(3, result)
    }

    @Test
    fun `alternating vowels and consonants returns correct count`() {
        val s = "ababab"
        val k = 4
        println("Input: s=\"$s\", k=$k")
        val result = solution.maxVowels(s, k)
        println("Expected: 2 | Got: $result")
        assertEquals(2, result)
    }
}
