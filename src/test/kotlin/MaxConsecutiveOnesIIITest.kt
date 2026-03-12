import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxConsecutiveOnesIIITest {

    private val solution = MaxConsecutiveOnesIII()

    @Test
    fun `example 1 with k equal 2 returns 6`() {
        assertEquals(6, solution.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
    }

    @Test
    fun `example 2 with k equal 3 returns 10`() {
        assertEquals(10, solution.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3))
    }

    @Test
    fun `all ones with k equal 0 returns full length`() {
        assertEquals(5, solution.longestOnes(intArrayOf(1, 1, 1, 1, 1), 0))
    }

    @Test
    fun `all zeros with k equal 2 returns 2`() {
        assertEquals(2, solution.longestOnes(intArrayOf(0, 0, 0, 0, 0), 2))
    }

    @Test
    fun `alternating with no flips allowed returns 1`() {
        assertEquals(1, solution.longestOnes(intArrayOf(1, 0, 1, 0, 1), 0))
    }
}
