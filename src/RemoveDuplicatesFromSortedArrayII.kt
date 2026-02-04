/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 */

internal class RemoveDuplicatesFromSortedArrayII {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var left = 1
        var count = 1 // Count of the current element occurrences

        for (right in 1 ..< nums.size) {
            if (nums[right] == nums[right - 1]) {
                count++
            } else {
                count = 1
            }

            if (count <= 2) {
                nums[left] = nums[right]
                left++
            }
        }

        return left
    }
}

fun main() {
    val solution = RemoveDuplicatesFromSortedArrayII()

    // Test case 1: Example 1 from problem description
    val nums1 = intArrayOf(1, 1, 1, 2, 2, 3)
    val result1 = solution.removeDuplicates(nums1)
    val expected1 = intArrayOf(1, 1, 2, 2, 3)
    val pass1 = result1 == 5 && nums1.sliceArray(0..<result1).contentEquals(expected1)
    println("Test 1: Expected k=5, nums=[1,1,2,2,3], Got k=$result1, nums=${nums1.sliceArray(0..<result1).contentToString()} - ${if (pass1) "PASS" else "FAIL"}")

    // Test case 2: Example 2 from problem description
    val nums2 = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    val result2 = solution.removeDuplicates(nums2)
    val expected2 = intArrayOf(0, 0, 1, 1, 2, 3, 3)
    val pass2 = result2 == 7 && nums2.sliceArray(0..<result2).contentEquals(expected2)
    println("Test 2: Expected k=7, nums=[0,0,1,1,2,3,3], Got k=$result2, nums=${nums2.sliceArray(0..<result2).contentToString()} - ${if (pass2) "PASS" else "FAIL"}")

    // Test case 3: Single element
    val nums3 = intArrayOf(1)
    val result3 = solution.removeDuplicates(nums3)
    val expected3 = intArrayOf(1)
    val pass3 = result3 == 1 && nums3.sliceArray(0..<result3).contentEquals(expected3)
    println("Test 3: Expected k=1, nums=[1], Got k=$result3, nums=${nums3.sliceArray(0..<result3).contentToString()} - ${if (pass3) "PASS" else "FAIL"}")

    // Test case 4: Two same elements (allowed)
    val nums4 = intArrayOf(1, 1)
    val result4 = solution.removeDuplicates(nums4)
    val expected4 = intArrayOf(1, 1)
    val pass4 = result4 == 2 && nums4.sliceArray(0..<result4).contentEquals(expected4)
    println("Test 4: Expected k=2, nums=[1,1], Got k=$result4, nums=${nums4.sliceArray(0..<result4).contentToString()} - ${if (pass4) "PASS" else "FAIL"}")

    // Test case 5: Three same elements (should keep only 2)
    val nums5 = intArrayOf(1, 1, 1)
    val result5 = solution.removeDuplicates(nums5)
    val expected5 = intArrayOf(1, 1)
    val pass5 = result5 == 2 && nums5.sliceArray(0..<result5).contentEquals(expected5)
    println("Test 5: Expected k=2, nums=[1,1], Got k=$result5, nums=${nums5.sliceArray(0..<result5).contentToString()} - ${if (pass5) "PASS" else "FAIL"}")

    // Test case 6: All unique elements (no duplicates)
    val nums6 = intArrayOf(1, 2, 3, 4, 5)
    val result6 = solution.removeDuplicates(nums6)
    val expected6 = intArrayOf(1, 2, 3, 4, 5)
    val pass6 = result6 == 5 && nums6.sliceArray(0..<result6).contentEquals(expected6)
    println("Test 6: Expected k=5, nums=[1,2,3,4,5], Got k=$result6, nums=${nums6.sliceArray(0..<result6).contentToString()} - ${if (pass6) "PASS" else "FAIL"}")

    // Test case 7: All same elements (five 5s should become two 5s)
    val nums7 = intArrayOf(5, 5, 5, 5, 5)
    val result7 = solution.removeDuplicates(nums7)
    val expected7 = intArrayOf(5, 5)
    val pass7 = result7 == 2 && nums7.sliceArray(0..<result7).contentEquals(expected7)
    println("Test 7: Expected k=2, nums=[5,5], Got k=$result7, nums=${nums7.sliceArray(0..<result7).contentToString()} - ${if (pass7) "PASS" else "FAIL"}")

    // Test case 8: Negative numbers with duplicates
    val nums8 = intArrayOf(-3, -3, -2, -1, -1, -1, 0)
    val result8 = solution.removeDuplicates(nums8)
    val expected8 = intArrayOf(-3, -3, -2, -1, -1, 0)
    val pass8 = result8 == 6 && nums8.sliceArray(0..<result8).contentEquals(expected8)
    println("Test 8: Expected k=6, nums=[-3,-3,-2,-1,-1,0], Got k=$result8, nums=${nums8.sliceArray(0..<result8).contentToString()} - ${if (pass8) "PASS" else "FAIL"}")

    // Test case 9: Two pairs of duplicates
    val nums9 = intArrayOf(1, 1, 2, 2)
    val result9 = solution.removeDuplicates(nums9)
    val expected9 = intArrayOf(1, 1, 2, 2)
    val pass9 = result9 == 4 && nums9.sliceArray(0..<result9).contentEquals(expected9)
    println("Test 9: Expected k=4, nums=[1,1,2,2], Got k=$result9, nums=${nums9.sliceArray(0..<result9).contentToString()} - ${if (pass9) "PASS" else "FAIL"}")

    // Test case 10: Mix of different duplicate counts
    val nums10 = intArrayOf(1, 1, 1, 1, 2, 2, 3, 4, 4, 4)
    val result10 = solution.removeDuplicates(nums10)
    val expected10 = intArrayOf(1, 1, 2, 2, 3, 4, 4)
    val pass10 = result10 == 7 && nums10.sliceArray(0..<result10).contentEquals(expected10)
    println("Test 10: Expected k=7, nums=[1,1,2,2,3,4,4], Got k=$result10, nums=${nums10.sliceArray(0..<result10).contentToString()} - ${if (pass10) "PASS" else "FAIL"}")
}

