// changed: replaced "throw Exception" by "require"
class Triangle(private val a: Double, private val b: Double, private val c: Double) {

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    private val uniqueSideLengths = setOf(a, b, c)

    init {
        require (a > 0.0 && b > 0.0 && c > 0.0)
        require (a + b >= c && b + c >= a && c + a >= b)
    }

    val isEquilateral = uniqueSideLengths.size == 1
    val isIsosceles = uniqueSideLengths.size <= 2
    val isScalene = uniqueSideLengths.size == 3
}