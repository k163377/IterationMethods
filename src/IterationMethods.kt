import java.lang.RuntimeException

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
    if(n > nMax){
        println("収束しませんでした")
        throw RuntimeException()
    }
    //末尾再帰
    return iteration(f, xNew, cond, nMax, n+1)
}

fun main(args: Array<String>) {
    var ans = iteration(::newtonF, 10000000000000000000.0, ::condDouble)
    println(ans * ans * ans) //解は2^(1/3)になる
}
