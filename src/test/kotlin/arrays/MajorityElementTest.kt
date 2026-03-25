package arrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {

    private val solution = MajorityElement()

    @Test
    fun `example 1 returns 3`() {
        assertEquals(3, solution.majorityElement(intArrayOf(3, 2, 3)))
    }

    @Test
    fun `example 2 returns 2`() {
        assertEquals(2, solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }

    @Test
    fun `single element returns that element`() {
        assertEquals(1, solution.majorityElement(intArrayOf(1)))
    }

    @Test
    fun `all same elements returns that element`() {
        assertEquals(5, solution.majorityElement(intArrayOf(5, 5, 5, 5)))
    }

    @Test
    fun `majority at start of array`() {
        assertEquals(1, solution.majorityElement(intArrayOf(1, 1, 2)))
    }

    @Test
    fun `negative number as majority element`() {
        assertEquals(-1, solution.majorityElement(intArrayOf(-1, -1, -1, 2, 2)))
    }

    @Test
    fun `large majority present`() {
        assertEquals(7, solution.majorityElement(intArrayOf(7, 7, 7, 7, 3)))
    }

    @Test
    fun `majority at exact threshold`() {
        assertEquals(1, solution.majorityElement(intArrayOf(1, 2, 1, 2, 1)))
    }

    @Test
    fun `two identical elements`() {
        assertEquals(3, solution.majorityElement(intArrayOf(3, 3)))
    }

    @Test
    fun `zero as majority element`() {
        assertEquals(0, solution.majorityElement(intArrayOf(0, 0, 0, 1, 2)))
    }

    // Boyer-Moore approach
    @Test
    fun `boyer moore example 1 returns 3`() {
        assertEquals(3, solution.majorityElementBoyerMoore(intArrayOf(3, 2, 3)))
    }

    @Test
    fun `boyer moore example 2 returns 2`() {
        assertEquals(2, solution.majorityElementBoyerMoore(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }

    @Test
    fun `boyer moore negative number as majority`() {
        assertEquals(-1, solution.majorityElementBoyerMoore(intArrayOf(-1, -1, -1, 2, 2)))
    }

    // Sorting approach
    @Test
    fun `sorting example 1 returns 3`() {
        assertEquals(3, solution.majorityElementSorting(intArrayOf(3, 2, 3)))
    }

    @Test
    fun `sorting example 2 returns 2`() {
        assertEquals(2, solution.majorityElementSorting(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }

    @Test
    fun `sorting negative number as majority`() {
        assertEquals(-1, solution.majorityElementSorting(intArrayOf(-1, -1, -1, 2, 2)))
    }
}
