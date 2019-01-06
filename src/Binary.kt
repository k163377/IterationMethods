import kotlin.math.cos
import kotlin.math.sin

//piを求めるために使う式、x=piの場合この式の真値は0
fun binaryF(x: Double): Double = sin(x/4.0) - cos(x/4.0)