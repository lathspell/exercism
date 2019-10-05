// changed: replaced "sum(a-b)" by "b-a" :-)
// Have a look at leetwinski's solution for a math formula that replaces the sum loops!
class Squares(private val nr: Int) {
    fun squareOfSum() = (1..nr).sum().let { it * it } // why is there now power() method?
    fun sumOfSquares() = (1..nr).sumBy { it * it }
    fun difference() = squareOfSum() - sumOfSquares()
}
