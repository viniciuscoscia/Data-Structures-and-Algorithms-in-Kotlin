package slidingwindow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaxAverageTest {

    private val solution = FindMaxAverage()

    @Test
    fun `example from problem returns 12 75`() {
        assertEquals(12.75, solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4), 1e-5)
    }

    @Test
    fun `single element returns that element`() {
        assertEquals(5.0, solution.findMaxAverage(intArrayOf(5), 1), 1e-5)
    }

    @Test
    fun `all same elements returns that element`() {
        assertEquals(3.0, solution.findMaxAverage(intArrayOf(3, 3, 3, 3, 3), 3), 1e-5)
    }

    @Test
    fun `all negative numbers returns least negative average`() {
        assertEquals(-1.5, solution.findMaxAverage(intArrayOf(-1, -2, -3, -4, -5), 2), 1e-5)
    }

    @Test
    fun `k equals array length returns overall average`() {
        assertEquals(2.5, solution.findMaxAverage(intArrayOf(1, 2, 3, 4), 4), 1e-5)
    }
}
