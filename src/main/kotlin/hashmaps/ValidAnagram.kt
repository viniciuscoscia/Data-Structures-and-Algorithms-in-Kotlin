package hashmaps

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An anagram is a word formed by rearranging the letters of another word,
 * using all original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 *
 * Follow-up: What if the inputs contain Unicode characters?
 * A frequency map (HashMap<Char, Int>) handles any character set, unlike a fixed-size array.
 */
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val freq = IntArray(26)

        for (i in s.indices) {
            freq[s[i] - 'a']++
            freq[t[i] - 'a']--
        }

        return freq.all { it == 0 }
    }
}
