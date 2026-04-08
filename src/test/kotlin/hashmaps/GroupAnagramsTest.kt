package hashmaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GroupAnagramsTest {

    private val solution = GroupAnagrams()

    private fun normalize(result: List<List<String>>): List<List<String>> =
        result.map { it.sorted() }.sortedBy { it.firstOrNull() ?: "" }

    @Test
    fun `mixed anagrams groups all three clusters correctly`() {
        val input = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
        val expected = listOf(listOf("ate", "eat", "tea"), listOf("bat"), listOf("nat", "tan"))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `single empty string returns one group with empty string`() {
        val input = arrayOf("")
        val expected = listOf(listOf(""))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `single character returns one group with that character`() {
        val input = arrayOf("a")
        val expected = listOf(listOf("a"))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `all strings are anagrams of each other returns one group`() {
        val input = arrayOf("abc", "bca", "cab", "cba")
        val expected = listOf(listOf("abc", "bca", "cab", "cba"))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `no anagrams at all returns each string in its own group`() {
        val input = arrayOf("cat", "dog", "bird")
        val expected = listOf(listOf("bird"), listOf("cat"), listOf("dog"))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `strings with different lengths are never grouped together`() {
        val input = arrayOf("a", "aa", "aaa")
        val expected = listOf(listOf("a"), listOf("aa"), listOf("aaa"))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `duplicate strings are placed in the same group`() {
        val input = arrayOf("eat", "eat", "tea")
        val expected = listOf(listOf("eat", "eat", "tea"))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `multiple empty strings are grouped together`() {
        val input = arrayOf("", "", "")
        val expected = listOf(listOf("", "", ""))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }

    @Test
    fun `single-element input with multi-character string returns one group`() {
        val input = arrayOf("listen")
        val expected = listOf(listOf("listen"))
        println("Input: ${input.contentToString()}")
        val result = solution.groupAnagrams(input)
        println("Expected: $expected | Got: $result")
        assertEquals(normalize(expected), normalize(result))
    }
}
