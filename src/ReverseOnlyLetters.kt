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
 */
class ReverseOnlyLetters {
    fun reverseOnlyLetters(s: String): String {
        var reverse = CharArray(s.length)
        var left = 0

        for (right in s.length - 1 downTo 0) {
            println(right)
        }

        return reverse.concatToString()
    }

    private fun Char.isLetter(): Boolean {
        val digitToInt = this.digitToInt()
        return (digitToInt in 101..<133) || (digitToInt in 141..172)
    }
}

fun main() {
    val solution = ReverseOnlyLetters()

    // Test 1: Basic with single separator
    val result1 = solution.reverseOnlyLetters("ab-cd")
    println("Test 1: Expected \"dc-ba\", Got \"$result1\" - ${if (result1 == "dc-ba") "PASS" else "FAIL"}")

    // Test 2: Multiple separators
    val result2 = solution.reverseOnlyLetters("a-bC-dEf-ghIj")
    println("Test 2: Expected \"j-Ih-gfE-dCba\", Got \"$result2\" - ${if (result2 == "j-Ih-gfE-dCba") "PASS" else "FAIL"}")

    // Test 3: Mixed digits and special characters
    val result3 = solution.reverseOnlyLetters("Test1ng-Leet=code-Q!")
    println("Test 3: Expected \"Qedo1ct-eeLg=ntse-T!\", Got \"$result3\" - ${if (result3 == "Qedo1ct-eeLg=ntse-T!") "PASS" else "FAIL"}")

    // Test 4: Single letter
    val result4 = solution.reverseOnlyLetters("a")
    println("Test 4: Expected \"a\", Got \"$result4\" - ${if (result4 == "a") "PASS" else "FAIL"}")

    // Test 5: No letters (all special characters)
    val result5 = solution.reverseOnlyLetters("---")
    println("Test 5: Expected \"---\", Got \"$result5\" - ${if (result5 == "---") "PASS" else "FAIL"}")

    // Test 6: All letters, no special characters
    val result6 = solution.reverseOnlyLetters("abcdef")
    println("Test 6: Expected \"fedcba\", Got \"$result6\" - ${if (result6 == "fedcba") "PASS" else "FAIL"}")

    // Test 7: Special characters at both ends
    val result7 = solution.reverseOnlyLetters("-abc-")
    println("Test 7: Expected \"-cba-\", Got \"$result7\" - ${if (result7 == "-cba-") "PASS" else "FAIL"}")

    // Test 8: Single special character
    val result8 = solution.reverseOnlyLetters("-")
    println("Test 8: Expected \"-\", Got \"$result8\" - ${if (result8 == "-") "PASS" else "FAIL"}")

    // Test 9: Letters and digits interleaved
    val result9 = solution.reverseOnlyLetters("a1b2c3")
    println("Test 9: Expected \"c1b2a3\", Got \"$result9\" - ${if (result9 == "c1b2a3") "PASS" else "FAIL"}")

    // Test 10: Two letters only
    val result10 = solution.reverseOnlyLetters("AB")
    println("Test 10: Expected \"BA\", Got \"$result10\" - ${if (result10 == "BA") "PASS" else "FAIL"}")
}