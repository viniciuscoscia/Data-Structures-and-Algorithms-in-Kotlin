import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayIITest {

    private val solution = RemoveDuplicatesFromSortedArrayII()

    @Test
    fun `example 1 keeps at most two of each element`() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val k = solution.removeDuplicates(nums)
        assertEquals(5, k)
        assertArrayEquals(intArrayOf(1, 1, 2, 2, 3), nums.sliceArray(0..<k))
    }

    @Test
    fun `example 2 keeps at most two of each element`() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val k = solution.removeDuplicates(nums)
        assertEquals(7, k)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 3, 3), nums.sliceArray(0..<k))
    }

    @Test
    fun `single element returns k equal 1`() {
        val nums = intArrayOf(1)
        val k = solution.removeDuplicates(nums)
        assertEquals(1, k)
        assertArrayEquals(intArrayOf(1), nums.sliceArray(0..<k))
    }

    @Test
    fun `two same elements are both kept`() {
        val nums = intArrayOf(1, 1)
        val k = solution.removeDuplicates(nums)
        assertEquals(2, k)
        assertArrayEquals(intArrayOf(1, 1), nums.sliceArray(0..<k))
    }

    @Test
    fun `three same elements keeps only two`() {
        val nums = intArrayOf(1, 1, 1)
        val k = solution.removeDuplicates(nums)
        assertEquals(2, k)
        assertArrayEquals(intArrayOf(1, 1), nums.sliceArray(0..<k))
    }

    @Test
    fun `all unique elements are kept`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = solution.removeDuplicates(nums)
        assertEquals(5, k)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), nums.sliceArray(0..<k))
    }

    @Test
    fun `all same elements reduces to two`() {
        val nums = intArrayOf(5, 5, 5, 5, 5)
        val k = solution.removeDuplicates(nums)
        assertEquals(2, k)
        assertArrayEquals(intArrayOf(5, 5), nums.sliceArray(0..<k))
    }

    @Test
    fun `negative numbers with duplicates`() {
        val nums = intArrayOf(-3, -3, -2, -1, -1, -1, 0)
        val k = solution.removeDuplicates(nums)
        assertEquals(6, k)
        assertArrayEquals(intArrayOf(-3, -3, -2, -1, -1, 0), nums.sliceArray(0..<k))
    }

    @Test
    fun `two pairs of duplicates are all kept`() {
        val nums = intArrayOf(1, 1, 2, 2)
        val k = solution.removeDuplicates(nums)
        assertEquals(4, k)
        assertArrayEquals(intArrayOf(1, 1, 2, 2), nums.sliceArray(0..<k))
    }

    @Test
    fun `mix of different duplicate counts`() {
        val nums = intArrayOf(1, 1, 1, 1, 2, 2, 3, 4, 4, 4)
        val k = solution.removeDuplicates(nums)
        assertEquals(7, k)
        assertArrayEquals(intArrayOf(1, 1, 2, 2, 3, 4, 4), nums.sliceArray(0..<k))
    }
}
