package twopointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseOnlyLettersTest {

    private val solution = ReverseOnlyLetters()

    @Test
    fun `basic string with single separator`() {
        assertEquals("dc-ba", solution.reverseOnlyLetters("ab-cd"))
    }

    @Test
    fun `multiple separators mixed case`() {
        assertEquals("j-Ih-gfE-dCba", solution.reverseOnlyLetters("a-bC-dEf-ghIj"))
    }

    @Test
    fun `digits and special characters stay in place`() {
        assertEquals("Qedo1ct-eeLg=ntse-T!", solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"))
    }

    @Test
    fun `single letter is unchanged`() {
        assertEquals("a", solution.reverseOnlyLetters("a"))
    }

    @Test
    fun `no letters all special characters unchanged`() {
        assertEquals("---", solution.reverseOnlyLetters("---"))
    }

    @Test
    fun `all letters with no separators are fully reversed`() {
        assertEquals("fedcba", solution.reverseOnlyLetters("abcdef"))
    }

    @Test
    fun `special characters at both ends stay in place`() {
        assertEquals("-cba-", solution.reverseOnlyLetters("-abc-"))
    }

    @Test
    fun `single special character is unchanged`() {
        assertEquals("-", solution.reverseOnlyLetters("-"))
    }

    @Test
    fun `letters and digits interleaved`() {
        assertEquals("c1b2a3", solution.reverseOnlyLetters("a1b2c3"))
    }

    @Test
    fun `two letters are swapped`() {
        assertEquals("BA", solution.reverseOnlyLetters("AB"))
    }
}
