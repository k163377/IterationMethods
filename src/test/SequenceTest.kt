package test

import main.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.PI

class SequenceTest{
    @Test //netwon法でx^3-2=0となるxを計算
    fun testIterationSequence(){
        val ans = iterationSequence(::newtonF, 1.0, ::condDouble)
        val last = ans.last()
        Assertions.assertTrue(10000 > ans.size)
        Assertions.assertEquals(2.0, last * last * last, Float.MIN_VALUE.toDouble())
    }

    @Test //二分法でsin(x/4) - cos(x/4) = 0（つまりx = pi）となるxを計算
    fun testBinarySequence(){
        val ans = binaryIterationSequence(::binaryF, 0.0, 0.0, 5.0)
        Assertions.assertTrue(10000 > ans.size)
        Assertions.assertEquals(PI, ans.last(), 1.0E-15)
    }
}
