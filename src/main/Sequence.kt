package main

import java.lang.RuntimeException
import kotlin.math.abs

//反復法
fun<T : Any> iterationSequence(
    f: (T) -> T, //漸化式
    x0: T, //初期値
    cond: (T, T) -> Boolean, //収束条件
    nMax: Int = 10000 //反復回数上限
): List<T> = generateSequence( Pair<T?, T>(null, x0)) { (_, xNew) ->
    xNew to f(xNew)  //xの更新
}.takeFor { (x, xNew) ->
    if(x == null) true else !cond(x, xNew) //収束判定、xは初期値nullなのでnull回避が必要
}.map {
    it.second //Pairから配列へ変換
}.take(nMax).toList() //nMaxまで行ったら終了、Listにして返却

//二分法の中点計算用
fun calcHalf(a: Double, b: Double): Double = (a + b) / 2.0
//二分法
fun binaryIterationSequence(
    f: (Double) -> Double, //入力関数
    trueValue: Double, //二分法の真値
    a0: Double, //小さい方の初期値
    b0: Double, //大きい方の初期値
    nMax: Int = 10000 //反復回数上限
): List<Double> = generateSequence(Triple(a0, b0, calcHalf(a0, b0))) { (a, b, c) ->
    when { //更新
        f(a) * f(c) > 0.0 -> Triple(c, b, calcHalf(c, b))
        f(b) * f(c) > 0.0 -> Triple(a, c,  calcHalf(a, c))
        else -> throw RuntimeException("条件判定に失敗しました")
    }
}.map {
    it.third //Tripleから配列へ変換
}.takeFor {
    abs(f(it) - trueValue) >= 1.0E-15 //収束判定
}.take(nMax).toList() //nMaxまで行ったら終了、Listにして返却
