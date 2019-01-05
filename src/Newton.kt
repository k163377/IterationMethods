import kotlin.math.abs

//Double用の判定式、Float.MIN_VALUEはFloatの最小少数、計算機的に十分小さい値として利用
fun condDouble(x: Double, xNew: Double): Boolean = abs(x - xNew) < Float.MIN_VALUE.toDouble()

//ニュートン法でf(x) = x^3 - 2.0のx=0における実数解を求めるための漸化式
fun newtonF(x: Double): Double = x - ((x*x*x - 2.0) / (3.0*x*x))