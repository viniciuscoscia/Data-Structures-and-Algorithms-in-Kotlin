import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReversePrefixTest {

    private val solution = ReversePrefix()

    @Test
    fun `example 1 reverses prefix up to first d`() {
        val word = "abcdefd"
        val expected = "dcbaefd"
        println("Input: word=\"$word\", ch='d'")
        val result = solution.reversePrefix(word, 'd')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }

    @Test
    fun `example 2 reverses prefix up to first z`() {
        val word = "xyxzxe"
        val expected = "zxyxxe"
        println("Input: word=\"$word\", ch='z'")
        val result = solution.reversePrefix(word, 'z')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }

    @Test
    fun `example 3 character not found returns word unchanged`() {
        val word = "abcd"
        val expected = "abcd"
        println("Input: word=\"$word\", ch='z'")
        val result = solution.reversePrefix(word, 'z')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }

    @Test
    fun `character is first letter reverses only one char`() {
        val word = "abcd"
        val expected = "abcd"
        println("Input: word=\"$word\", ch='a'")
        val result = solution.reversePrefix(word, 'a')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }

    @Test
    fun `character is last letter reverses entire word`() {
        val word = "abcd"
        val expected = "dcba"
        println("Input: word=\"$word\", ch='d'")
        val result = solution.reversePrefix(word, 'd')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }

    @Test
    fun `single character word matching ch returns same word`() {
        val word = "a"
        val expected = "a"
        println("Input: word=\"$word\", ch='a'")
        val result = solution.reversePrefix(word, 'a')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }

    @Test
    fun `duplicate ch uses only first occurrence`() {
        val word = "abcdefd"
        val expected = "dcbaefd"
        println("Input: word=\"$word\", ch='d'")
        val result = solution.reversePrefix(word, 'd')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }

    @Test
    fun `all same characters reverses prefix up to first occurrence`() {
        val word = "aaaa"
        val expected = "aaaa"
        println("Input: word=\"$word\", ch='a'")
        val result = solution.reversePrefix(word, 'a')
        println("Expected: \"$expected\" | Got: \"$result\"")
        assertEquals(expected, result)
    }
}
