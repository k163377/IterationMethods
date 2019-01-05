import java.lang.RuntimeException
import kotlin.math.abs
import kotlin.math.pow

//非収束時のException出力
fun<T> notConverged(ans: T) { throw RuntimeException("収束しませんでした ans: $ans") }

//反復法の本体
tailrec fun<T> iteration(
    f: (T) -> T, //漸化式
    x: T, //反復中の値
    cond: (T, T) -> Boolean, //収束条件
    nMax: Int = 10000, //反復回数上限
    n: Int = 1 //反復回数
): T {
    //値の更新
    val xNew = f(x)
    //収束判定
    if(cond(x, xNew)){
        println("反復回数: $n, x: $xNew")
        return xNew
    }
    //反復回数判定
    if(n > nMax) notConverged(xNew)
    //末尾再帰
    return iteration(f, xNew, cond, nMax, n+1)
}

//二分法の本体
tailrec fun binaryIteration(
    f: (Double) -> Double, //入力関数
    a: Double,
    b: Double,
    cond: (Double) -> Boolean, //判定関数
    nMax: Int = 10000, //反復回数上限
    n: Int = 1 //反復回数
): Double {
    val c = (a + b) / 2.0
    if(cond(c)){
        println("反復回数: $n, ans: $c")
        return c
    }
    //反復回数判定
    if(n > nMax) notConverged(c)
    return when {
        f(a) * f(c) > 0 -> binaryIteration(f, c, b, cond, nMax, n+1)
        f(b)*f(c) > 0 -> binaryIteration(f, a, c, cond, nMax, n+1)
        else -> throw RuntimeException("条件判定に失敗しました")
    }
}

fun main(args: Array<String>) {
    val newtonAns = iteration(::newtonF, 10000000000000000000.0, ::condDouble)
    println(newtonAns * newtonAns * newtonAns) //解は2^(1/3)になる
    //(恐らくsin/cosの精度が原因で)Float.MIN_VALUEの精度が出なかったので、Wikipediaの記載から10^(-15)を採用
    val binaryAns =
        binaryIteration(::binaryF, 0.0, 5.0, { abs(binaryF(it)) < 10.0.pow(-15) })
    println(binaryAns)
}
