package test

import main.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.PI

class SequenceTest{
    @Test
    fun testIterationSequence(){
        val ans = iterationSequence(::newtonF, 1.0, ::condDouble)
        val last = ans.last()
        Assertions.assertTrue(10000 > ans.size)
        Assertions.assertEquals(2.0, last * last * last, Float.MIN_VALUE.toDouble())
    }

    @Test
    fun testBinarySequence(){
        val ans = binaryIterationSequence(::binaryF, 0.0, 0.0, 5.0)
        Assertions.assertTrue(10000 > ans.size)
        Assertions.assertEquals(PI, ans.last(), 1.0E-15)
    }
}
