package hashmaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidAnagramTest {

    private val solution = ValidAnagram()

    @Test
    fun `classic anagram returns true`() {
        val s = "anagram"
        val t = "nagaram"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `different letters returns false`() {
        val s = "rat"
        val t = "car"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `different lengths returns false`() {
        val s = "ab"
        val t = "abc"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `identical strings returns true`() {
        val s = "hello"
        val t = "hello"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `single identical characters returns true`() {
        val s = "a"
        val t = "a"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `single different characters returns false`() {
        val s = "a"
        val t = "b"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `same characters different frequencies returns false`() {
        val s = "aab"
        val t = "abb"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `all same characters returns true`() {
        val s = "aaaa"
        val t = "aaaa"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `one character off returns false`() {
        val s = "abcde"
        val t = "abcdf"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }

    @Test
    fun `longer anagram with repeated chars returns true`() {
        val s = "aabbcc"
        val t = "ccbbaa"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: true | Got: $result")
        assertEquals(true, result)
    }

    @Test
    fun `aacc and ccac have different frequencies returns false`() {
        val s = "aacc"
        val t = "ccac"
        println("Input: s=\"$s\", t=\"$t\"")
        val result = solution.isAnagram(s, t)
        println("Expected: false | Got: $result")
        assertEquals(false, result)
    }
}
