
class BaseConverter(private val oldBase: Int, private val oldDigits: IntArray) {

    init {
        require(oldBase >= 2) { "Bases must be at least 2." }
        require(oldDigits.isNotEmpty()) { "You must supply at least one digit." }
        require(oldDigits.all { it < oldBase }) { "All digits must be strictly less than the base." }
        require(if (oldDigits.size == 1) true else oldDigits[0] != 0) { "Digits may not contain leading zeros." }
        require(oldDigits.none { it < 0 }) { "Digits may not be negative." }
    }

    fun convertToBase(newBase: Int): IntArray = fromDec(newBase, toDec(oldBase, oldDigits))

    private fun fromDec(base: Int, n: Int): IntArray =
            if (n == 0)
                intArrayOf(0)
            else
                fromDecimalRecursive(base, n, n.log(base)).toIntArray()

    private fun fromDecimalRecursive(base: Int, n: Int, exponent: Int): List<Int> {
        require(base >= 2) { "Bases must be at least 2." }

        if (exponent < 0) {
            return listOf()
        }

        val powered = base.pow(exponent)
        val factor = n / powered
        return listOf(factor) + fromDecimalRecursive(base, n - factor * powered, exponent - 1)
    }

    private fun toDec(base: Int, digits: IntArray): Int = digits
            .reversed()
            .foldIndexed(0) { i, acc, digit ->
                acc + digit * base.pow(i)
            }

    private fun Int.pow(exp: Int): Int = Math.pow(this.toDouble(), exp.toDouble()).toInt()
    private fun Int.log(base: Int): Int = (Math.log(this.toDouble()) / Math.log(base.toDouble())).toInt()
}
