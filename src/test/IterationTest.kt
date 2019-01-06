package test

import main.condDouble
import main.easyNewtonF
import main.iteration
import main.newtonF
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IterationTest {
    @Test
    fun testNewton() {
        val ans = iteration(::newtonF, 1.0, ::condDouble)
        assertEquals(2.0, ans * ans * ans, Float.MIN_VALUE.toDouble())
    }

    @Test
    fun testEasyNewton() {
        val ans = iteration(::easyNewtonF, 1.0, ::condDouble)
        assertEquals(2.0, ans * ans * ans, Float.MIN_VALUE.toDouble())
    }
}
