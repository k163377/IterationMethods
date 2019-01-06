package main

import java.lang.RuntimeException

//非収束時のException出力
fun<T> notConverged(ans: T) { throw RuntimeException("収束しませんでした ans: $ans") }
