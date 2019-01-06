package test

import main.condDouble
import main.iterationSequence
import main.newtonF
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SequenceTest{
    @Test
    fun testIterationSequence(){
        val ans = iterationSequence(::newtonF, 1.0, ::condDouble)
        val last = ans.last()
        Assertions.assertEquals(2.0, last * last * last, Float.MIN_VALUE.toDouble())
    }
}