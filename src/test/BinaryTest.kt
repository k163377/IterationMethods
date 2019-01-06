package test

import main.binaryF
import main.binaryIteration
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.PI

class BinaryTest{
    @Test
    fun testBinary(){
        val ans = binaryIteration(::binaryF, 0.0, 0.0, 5.0)
        assertEquals(PI, ans, 1.0E-15)
    }
}
