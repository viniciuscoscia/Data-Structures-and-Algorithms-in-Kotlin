import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RotateArrayTest {

    private val solution = RotateArray()

    @Test
    fun `example 1 rotates right by 3 steps`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        solution.rotate(nums, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
    }

    @Test
    fun `example 2 rotates right by 2 steps`() {
        val nums = intArrayOf(-1, -100, 3, 99)
        solution.rotate(nums, 2)
        assertArrayEquals(intArrayOf(3, 99, -1, -100), nums)
    }

    @Test
    fun `single element with k larger than array size stays unchanged`() {
        val nums = intArrayOf(-1)
        solution.rotate(nums, 2)
        assertArrayEquals(intArrayOf(-1), nums)
    }

    @Test
    fun `k equal to array length results in no change`() {
        val nums = intArrayOf(1, 2, 3, 4)
        solution.rotate(nums, 4)
        assertArrayEquals(intArrayOf(1, 2, 3, 4), nums)
    }

    @Test
    fun `k equal to zero results in no change`() {
        val nums = intArrayOf(1, 2, 3)
        solution.rotate(nums, 0)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }
}
