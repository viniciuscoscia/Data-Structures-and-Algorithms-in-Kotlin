package twopointers

/**
 * 917. Reverse Only Letters
 *
 * Given a string s, reverse the string according to the following rules:
 * - All the characters that are not English letters remain in the same position.
 * - All the English letters (lowercase or uppercase) should be reversed.
 *
 * Return s after reversing it.
 *
 * Example 1:
 *   Input: s = "ab-cd"
 *   Output: "dc-ba"
 *
 * Example 2:
 *   Input: s = "a-bC-dEf-ghIj"
 *   Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 *   Input: s = "Test1ng-Leet=code-Q!"
 *   Output: "Qedo1ct-eeLg=ntse-T!"
 *
 * Constraints:
 *   1 <= s.length <= 100
 *   s consists of characters with ASCII values in the range [33, 122].
 *   s does not contain '"' or '\\'.
 * Complexity: O(n) time, O(n) space — result is built into a new CharArray
 */
class ReverseOnlyLetters {
    // TODO (Rank 3) — Fragile logic: relies on the default zero-value of CharArray as a sentinel to track
    // written positions. Also contains Portuguese comments that should be in English.
    fun reverseOnlyLetters(s: String): String {
        val reverse = CharArray(s.length)
        var left = 0
        var right = s.length - 1

        while (left < s.length) {
            val currentCharacter = s[left]

            if (currentCharacter.isLetter()) {
                if (s[right].isLetter() && reverse[right].code == 0) { // Colocar no right index se não for local para caractere especial
                    reverse[right] = currentCharacter
                    left++
                    right--
                } else { // Pular
                    right--
                }
            } else { // Colocar no left index
                reverse[left] = currentCharacter
                left++
            }
        }

        return reverse.concatToString()
    }

    private fun Char.isLetter(): Boolean {
        return (code in 65.. 90) || (code in 97..122)
    }
}
