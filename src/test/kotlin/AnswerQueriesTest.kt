import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AnswerQueriesTest {

    private val solution = AnswerQueries()

    @Test
    fun `single query with sum less than limit returns true`() {
        assertArrayEquals(
            booleanArrayOf(true),
            solution.answerQueries(intArrayOf(1, 6, 3, 2, 7, 2), arrayOf(intArrayOf(0, 3)), 13)
        )
    }

    @Test
    fun `multiple queries with mixed results`() {
        assertArrayEquals(
            booleanArrayOf(true, false, true),
            solution.answerQueries(
                intArrayOf(1, 6, 3, 2, 7, 2),
                arrayOf(intArrayOf(0, 3), intArrayOf(2, 5), intArrayOf(2, 4)),
                13
            )
        )
    }

    @Test
    fun `single element query within limit returns true`() {
        assertArrayEquals(
            booleanArrayOf(true),
            solution.answerQueries(intArrayOf(5, 3, 8, 2), arrayOf(intArrayOf(1, 1)), 5)
        )
    }

    @Test
    fun `full array query sum less than limit returns true`() {
        assertArrayEquals(
            booleanArrayOf(true),
            solution.answerQueries(intArrayOf(2, 3, 4, 5), arrayOf(intArrayOf(0, 3)), 15)
        )
    }

    @Test
    fun `sum equal to limit returns false`() {
        assertArrayEquals(
            booleanArrayOf(false),
            solution.answerQueries(intArrayOf(10, 20, 30), arrayOf(intArrayOf(0, 2)), 60)
        )
    }

    @Test
    fun `negative numbers with multiple queries`() {
        assertArrayEquals(
            booleanArrayOf(true, false),
            solution.answerQueries(
                intArrayOf(-5, 3, -2, 8),
                arrayOf(intArrayOf(0, 2), intArrayOf(1, 3)),
                0
            )
        )
    }
}
