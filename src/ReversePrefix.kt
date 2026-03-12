/**
 * 2000. Reverse Prefix of Word
 *
 * Given a 0-indexed string word and a character ch, reverse the segment of word
 * that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
 * If ch does not exist in word, do nothing.
 *
 * Example 1:
 *   Input:  word = "abcdefd", ch = 'd'
 *   Output: "dcbaefd"
 *   Explanation: First 'd' is at index 3; reverse word[0..3] → "dcba" + "efd"
 *
 * Example 2:
 *   Input:  word = "xyxzxe", ch = 'z'
 *   Output: "zxyxxe"
 *   Explanation: First 'z' is at index 3; reverse word[0..3] → "zxyx" + "xe"
 *
 * Example 3:
 *   Input:  word = "abcd", ch = 'z'
 *   Output: "abcd"
 *   Explanation: 'z' does not exist in word; return unchanged.
 *
 * Constraints:
 *   1 <= word.length <= 250
 *   word consists of lowercase English letters.
 *   ch is a lowercase English letter.
 *
 * @see <a href="https://leetcode.com/problems/reverse-prefix-of-word/">LeetCode 2000</a>
 */
class ReversePrefix {
    fun reversePrefix(word: String, ch: Char): String {
        var right = 0
        while (right < word.length) {
            if (word[right] == ch) {
                val stringBuilder = buildString {
                    (right downTo 0).forEach { index ->
                        append(word[index])
                    }
                }

                return stringBuilder + word.substring(right + 1, word.length)
            }
            right++
        }

        return word
    }
}
