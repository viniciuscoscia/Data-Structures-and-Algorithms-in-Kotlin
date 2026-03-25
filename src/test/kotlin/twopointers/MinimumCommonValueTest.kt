package twopointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCommonValueTest {

    private val solution = MinimumCommonValue()

    @Test
    fun `single common element`() {
        assertEquals(2, solution.getCommon(intArrayOf(1, 2, 3), intArrayOf(2, 4)))
    }

    @Test
    fun `multiple common elements returns the smallest`() {
        assertEquals(2, solution.getCommon(intArrayOf(1, 2, 3, 6), intArrayOf(2, 3, 4, 5)))
    }

    @Test
    fun `no common elements returns -1`() {
        assertEquals(-1, solution.getCommon(intArrayOf(1, 3, 5), intArrayOf(2, 4, 6)))
    }

    @Test
    fun `common element is the first in both arrays`() {
        assertEquals(1, solution.getCommon(intArrayOf(1, 2, 3), intArrayOf(1, 4, 5)))
    }

    @Test
    fun `common element is the last in both arrays`() {
        assertEquals(5, solution.getCommon(intArrayOf(1, 2, 5), intArrayOf(3, 4, 5)))
    }

    @Test
    fun `single-element arrays with a match`() {
        assertEquals(7, solution.getCommon(intArrayOf(7), intArrayOf(7)))
    }

    @Test
    fun `single-element arrays with no match returns -1`() {
        assertEquals(-1, solution.getCommon(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun `duplicate values in both arrays common element exists`() {
        assertEquals(1, solution.getCommon(intArrayOf(1, 1, 2, 3), intArrayOf(1, 1, 4)))
    }

    @Test
    fun `one array is a subset of the other`() {
        assertEquals(2, solution.getCommon(intArrayOf(2, 3, 4), intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `large boundary values with no common element returns -1`() {
        assertEquals(-1, solution.getCommon(intArrayOf(1_000_000_000), intArrayOf(999_999_999)))
    }

    @Test
    fun `common element is last in nums2 only`() {
        assertEquals(5, solution.getCommon(intArrayOf(1, 5), intArrayOf(2, 3, 4, 5)))
    }

    @Test
    fun `common element is last in nums1 only`() {
        assertEquals(9, solution.getCommon(intArrayOf(1, 2, 9), intArrayOf(3, 6, 9)))
    }

    @Test
    fun `nums1 entirely less than nums2 no common`() {
        assertEquals(-1, solution.getCommon(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun `My own test`() {
        assertEquals(1000, solution.getCommon(intArrayOf(4, 5, 6, 1000), intArrayOf(1, 2, 3, 1000)))
    }
}
