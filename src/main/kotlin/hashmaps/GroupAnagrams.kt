package hashmaps

/**
 * 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An anagram is a word formed by rearranging the letters of another word,
 * using all the original letters exactly once.
 *
 * Example 1:
 *   Input:  strs = ["eat","tea","tan","ate","nat","bat"]
 *   Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *   Input:  strs = [""]
 *   Output: [[""]]
 *
 * Example 3:
 *   Input:  strs = ["a"]
 *   Output: [["a"]]
 *
 * Constraints:
 *   - 1 <= strs.length <= 10^4
 *   - 0 <= strs[i].length <= 100
 *   - strs[i] consists of lowercase English letters
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<Int, ArrayList<String>>()

        strs.forEach { word ->
            val charCounter = MutableList(26) { 0 }
            word.forEach { c ->
                charCounter[c - 'a'] += 1
            }
            val hashCode = charCounter.hashCode()
            if (groups.containsKey(hashCode)) {
                groups[hashCode]!!.add(word)
            } else {
                groups[hashCode] = arrayListOf(word)
            }
        }

        return groups.values.toList()
    }
}
