/**
 * Answer Queries About Sum of Elements
 *
 * Given an array nums, a 2D array queries where queries[i] = [xi, yi], and an integer limit,
 * return a boolean array answer where answer[i] is true if the sum of nums (xi..yi) < limit.
 *
 * Complexity: O(n + q) time — O(n) to build prefix sums, O(q) to answer queries; O(n) space for prefix array.
 */
class AnswerQueries {
    fun answerQueries(nums: IntArray, queries: Array<IntArray>, limit: Int): BooleanArray {
        val prefix = IntArray(size = nums.size)
        prefix[0] = nums[0]

        for (i in 1..<nums.size) {
            prefix[i] = prefix[i - 1] + nums[i]
        }

        val ans = BooleanArray(size = queries.size)
        for (i in queries.indices) {
            val x = queries[i][0]
            val y = queries[i][1]
            val curr = prefix[y] - prefix[x] + nums[x]
            ans[i] = curr < limit
        }

        return ans
    }
}
