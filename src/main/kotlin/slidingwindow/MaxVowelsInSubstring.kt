package slidingwindow

import kotlin.math.max

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * Given a string s and an integer k, return the maximum number of vowel letters
 * in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */

class MaxVowelsInSubstring {
    fun maxVowels(s: String, k: Int): Int {
        var left = 0
        var maxVowels = 0
        var currentVowels = 0

        for (right in s.indices) {
            if (s[right] in "aeiou") {
                currentVowels++
            }

            if (right - left + 1 > k) {
                if (s[left] in "aeiou") {
                    currentVowels--
                }
                left++
            }

            maxVowels = maxOf(currentVowels, maxVowels)

            if (maxVowels == k) {
                return maxVowels
            }
        }

        return maxVowels
    }
}
