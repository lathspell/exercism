import kotlin.math.abs

class Squares(private val nr: Int) {
    fun squareOfSum() = (1..nr).sum().let { it * it }
    fun sumOfSquares() = (1..nr).sumBy { it * it }
    fun difference() = abs(sumOfSquares() - squareOfSum())
}