import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumValueToGetPositiveStepByStepSumTest {

    private val solution = MinimumValueToGetPositiveStepByStepSum()

    @Test
    fun `example 1 returns 5`() {
        assertEquals(5, solution.minStartValue(intArrayOf(-3, 2, -3, 4, 2)))
    }

    @Test
    fun `example 2 all positive returns 1`() {
        assertEquals(1, solution.minStartValue(intArrayOf(1, 2)))
    }

    @Test
    fun `example 3 returns 5`() {
        assertEquals(5, solution.minStartValue(intArrayOf(1, -2, -3)))
    }

    @Test
    fun `all positive numbers returns 1`() {
        assertEquals(1, solution.minStartValue(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `single negative number returns 6`() {
        assertEquals(6, solution.minStartValue(intArrayOf(-5)))
    }

    @Test
    fun `large negative cumulative sum returns 14`() {
        assertEquals(14, solution.minStartValue(intArrayOf(-10, 5, -8, 3)))
    }
}
