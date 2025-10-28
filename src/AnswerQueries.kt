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

fun main() {
    val solution = AnswerQueries()

    // Test case 1: Basic query with sum less than limit
    val result1 = solution.answerQueries(
        nums = intArrayOf(1, 6, 3, 2, 7, 2),
        queries = arrayOf(intArrayOf(0, 3)),
        limit = 13
    )
    println("Test 1: Expected [true], Got ${result1.contentToString()} - ${if (result1.contentEquals(booleanArrayOf(true))) "PASS" else "FAIL"}")

    // Test case 2: Multiple queries with different results
    val result2 = solution.answerQueries(
        nums = intArrayOf(1, 6, 3, 2, 7, 2),
        queries = arrayOf(intArrayOf(0, 3), intArrayOf(2, 5), intArrayOf(2, 4)),
        limit = 13
    )
    println("Test 2: Expected [true, false, true], Got ${result2.contentToString()} - ${if (result2.contentEquals(booleanArrayOf(true, false, true))) "PASS" else "FAIL"}")

    // Test case 3: Single element query
    val result3 = solution.answerQueries(
        nums = intArrayOf(5, 3, 8, 2),
        queries = arrayOf(intArrayOf(1, 1)),
        limit = 5
    )
    println("Test 3: Expected [true], Got ${result3.contentToString()} - ${if (result3.contentEquals(booleanArrayOf(true))) "PASS" else "FAIL"}")

    // Test case 4: All elements query
    val result4 = solution.answerQueries(
        nums = intArrayOf(2, 3, 4, 5),
        queries = arrayOf(intArrayOf(0, 3)),
        limit = 15
    )
    println("Test 4: Expected [true], Got ${result4.contentToString()} - ${if (result4.contentEquals(booleanArrayOf(true))) "PASS" else "FAIL"}")

    // Test case 5: Sum equal to limit (should be false since curr < limit)
    val result5 = solution.answerQueries(
        nums = intArrayOf(10, 20, 30),
        queries = arrayOf(intArrayOf(0, 2)),
        limit = 60
    )
    println("Test 5: Expected [false], Got ${result5.contentToString()} - ${if (result5.contentEquals(booleanArrayOf(false))) "PASS" else "FAIL"}")

    // Test case 6: Negative numbers
    val result6 = solution.answerQueries(
        nums = intArrayOf(-5, 3, -2, 8),
        queries = arrayOf(intArrayOf(0, 2), intArrayOf(1, 3)),
        limit = 0
    )
    println("Test 6: Expected [true, false], Got ${result6.contentToString()} - ${if (result6.contentEquals(booleanArrayOf(true, false))) "PASS" else "FAIL"}")
}