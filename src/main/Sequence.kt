package main

fun<T : Any> iterationSequence(
    f: (T) -> T, //漸化式
    x0: T, //初期値
    cond: (T, T) -> Boolean, //収束条件
    nMax: Int = 10000 //反復回数上限
): List<T> = generateSequence( Pair<T?, T>(null, x0)) { (_, xNew) ->
    xNew to f(xNew)  //xの更新
}.takeWhile { (x, xNew) ->
    if(x == null) true else !cond(x, xNew) //条件判定、xは初期値nullなのでnull回避が必要
}.map {
    it.second //Pairから配列へ変換
}.take(nMax).toList() //nMaxまで行ったら終了、Listにして返却
