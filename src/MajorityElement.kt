/**
 * 169. Majority Element
 *
 * Given an array `nums` of size `n`, return the majority element.
 *
 * The majority element is the element that appears more than `⌊n / 2⌋` times.
 * You may assume that the majority element always exists in the array.
 *
 * ## Examples
 *
 * **Example 1:**
 * ```
 * Input:  nums = [3, 2, 3]
 * Output: 3
 * Explanation: 3 appears 2 times (> ⌊3/2⌋ = 1).
 * ```
 *
 * **Example 2:**
 * ```
 * Input:  nums = [2, 2, 1, 1, 1, 2, 2]
 * Output: 2
 * Explanation: 2 appears 4 times (> ⌊7/2⌋ = 3).
 * ```
 *
 * ## Constraints
 * - `n == nums.length`
 * - `1 <= n <= 5 * 10⁴`
 * - `-10⁹ <= nums[i] <= 10⁹`
 * - The input is generated such that a majority element always exists.
 *
 * ## Approaches
 *
 * | Approach                  | Time         | Space | Method                                              |
 * |---------------------------|--------------|-------|------------------------------------------------------|
 * | HashMap with early exit   | O(n)         | O(n)  | Count frequencies, return once threshold is crossed  |
 * | Boyer-Moore Voting        | O(n)         | O(1)  | Cancel non-majority votes; the survivor is the answer|
 * | Sorting                   | O(n log n)   | O(1)  | After sorting, `nums[n/2]` is always the majority    |
 * | Randomized                | O(n) expected| O(1)  | Random pick has >50% chance of hitting majority      |
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * → Yes, the Boyer-Moore Voting Algorithm achieves this.
 *
 * @see <a href="https://leetcode.com/problems/majority-element/">LeetCode 169</a>
 */

class MajorityElement {

    // HashMap with early exit — O(n) time, O(n) space
    fun majorityElement(nums: IntArray): Int {
        val threshold = nums.size / 2
        val counter = mutableMapOf<Int, Int>()

        nums.forEach {
            val count = counter.getOrPut(it) { 0 } + 1
            counter[it] = count
            if (count > threshold) return it
        }

        throw IllegalArgumentException("No majority element found")
    }

    // Boyer-Moore Voting Algorithm — O(n) time, O(1) space
    fun majorityElementBoyerMoore(nums: IntArray): Int {
        var candidate = nums[0]
        var count = 0

        for (num in nums) {
            if (count == 0) candidate = num
            count += if (num == candidate) 1 else -1
        }

        return candidate
    }

    // Sorting — O(n log n) time, O(1) space
    fun majorityElementSorting(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }

    // Randomized — expected O(n) time, O(1) space
    fun majorityElementRandomized(nums: IntArray): Int {
        val threshold = nums.size / 2

        while (true) {
            val candidate = nums.random()
            var count = 0
            for (num in nums) {
                if (num == candidate) count++
            }
            if (count > threshold) return candidate
        }
    }
}

fun main() {
    val solution = MajorityElement()

    data class TestCase(val name: String, val nums: IntArray, val expected: Int)

    val testCases = listOf(
        TestCase("Example 1", intArrayOf(3, 2, 3), 3),
        TestCase("Example 2", intArrayOf(2, 2, 1, 1, 1, 2, 2), 2),
        TestCase("Single element", intArrayOf(1), 1),
        TestCase("All same", intArrayOf(5, 5, 5, 5), 5),
        TestCase("Majority first", intArrayOf(1, 1, 2), 1),
        TestCase("Negative numbers", intArrayOf(-1, -1, -1, 2, 2), -1),
        TestCase("Large majority", intArrayOf(7, 7, 7, 7, 3), 7),
        TestCase("Exact threshold", intArrayOf(1, 2, 1, 2, 1), 1),
        TestCase("Two elements", intArrayOf(3, 3), 3),
        TestCase("Zero as majority", intArrayOf(0, 0, 0, 1, 2), 0),
    )

    val approaches: List<Pair<String, (IntArray) -> Int>> = listOf(
        "HashMap (early exit)" to solution::majorityElement,
        "Boyer-Moore Voting" to solution::majorityElementBoyerMoore,
        "Sorting" to solution::majorityElementSorting,
        "Randomized" to solution::majorityElementRandomized,
    )

    for ((approachName, solve) in approaches) {
        println("=== $approachName ===")
        for ((i, tc) in testCases.withIndex()) {
            val result = solve(tc.nums.copyOf())
            val status = if (result == tc.expected) "PASS" else "FAIL"
            println("Test ${i + 1} (${tc.name}): Expected ${tc.expected}, Got $result - $status")
        }
        println()
    }
}