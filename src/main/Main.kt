package main

fun main(args: Array<String>) {
    val newtonAns = iteration(::newtonF, 1.0, ::condDouble)
    println(newtonAns * newtonAns * newtonAns) //解は2^(1/3)になる

    val easyNewtonAns = iteration(::easyNewtonF, 1.0, ::condDouble)
    println(easyNewtonAns * easyNewtonAns * easyNewtonAns)

    val binaryAns = binaryIteration(::binaryF, 0.0, 0.0, 5.0)
    println(binaryAns)
}
