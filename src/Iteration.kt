import kotlin.math.abs

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

//判定式、Float.MIN_VALUEはFloatの最小少数、計算機的に十分小さい値として利用
fun condDouble(x: Double, xNew: Double): Boolean = abs(x - xNew) < Float.MIN_VALUE.toDouble()

//ニュートン法でf(x) = x^3 - 2.0のx=0における実数解を求めるための漸化式
fun newtonF(x: Double): Double = x - ((x*x*x - 2.0) / (3.0*x*x))

//簡易ニュートン法、x0=1.0
fun easyNewtonF(x: Double): Double = x - ((x*x*x - 2.0) / 3.0)
