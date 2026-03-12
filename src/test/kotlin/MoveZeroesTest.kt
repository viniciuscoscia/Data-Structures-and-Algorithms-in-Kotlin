import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MoveZeroesTest {

    private val solution = MoveZeroes()

    @Test
    fun `example 1 moves zeroes to end preserving order`() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), nums)
    }

    @Test
    fun `single zero stays unchanged`() {
        val nums = intArrayOf(0)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(0), nums)
    }

    @Test
    fun `no zeroes leaves array unchanged`() {
        val nums = intArrayOf(1, 2, 3)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun `all zeroes stays all zeroes`() {
        val nums = intArrayOf(0, 0, 0)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(0, 0, 0), nums)
    }

    @Test
    fun `zero at end stays at end`() {
        val nums = intArrayOf(1, 2, 0)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(1, 2, 0), nums)
    }

    @Test
    fun `zero at start moves to end`() {
        val nums = intArrayOf(0, 1)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(1, 0), nums)
    }

    @Test
    fun `multiple zeroes interspersed`() {
        val nums = intArrayOf(0, 0, 1, 0, 2, 0, 3)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(1, 2, 3, 0, 0, 0, 0), nums)
    }

    @Test
    fun `negative numbers are treated as non-zero`() {
        val nums = intArrayOf(-1, 0, -3, 0, 2)
        println("Initial ${nums.contentToString()}")
        solution.moveZeroes(nums)
        println("Final ${nums.contentToString()}")
        assertArrayEquals(intArrayOf(-1, -3, 2, 0, 0), nums)
    }
}
