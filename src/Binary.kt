import java.lang.RuntimeException
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

//二分法の本体
tailrec fun binaryIteration(
    f: (Double) -> Double, //入力関数
    trueValue: Double, //2分法の真値
    a: Double, //小さい方
    b: Double, //大きい方
    nMax: Int = 10000, //反復回数上限
    n: Int = 1 //反復回数
): Double {
    val c = (a + b) / 2.0
    //Doubleの二分法ではFloat.MIN_VALUEの精度が出なかったので、Wikipediaの記載から10^(-15)を採用
    if(abs(f(c) - trueValue) < 1.0E-15){
        println("反復回数: $n, ans: $c")
        return c
    }
    //反復回数判定
    if(n > nMax) notConverged(c)
    return when {
        f(a) * f(c) > 0 -> binaryIteration(f, trueValue, c, b, nMax, n+1)
        f(b) * f(c) > 0 -> binaryIteration(f, trueValue, a, c, nMax, n+1)
        else -> throw RuntimeException("条件判定に失敗しました")
    }
}

//piを求めるために使う式、x=piの場合この式の真値は0
fun binaryF(x: Double): Double = sin(x/4.0) - cos(x/4.0)
