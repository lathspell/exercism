class Triangle(private val a: Double, private val b: Double, private val c: Double) {

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    private val uniqueSideLengths = setOf(a, b, c)

    init {
        if (a <= 0.0 || b <= 0.0 || c <= 0.0) throw IllegalArgumentException("All sides must be greater than 0!")
        if (a + b < c || b + c < a || c + a < b) throw IllegalArgumentException("Triangle Inequality!")
    }

    val isEquilateral = uniqueSideLengths.size == 1
    val isIsosceles = uniqueSideLengths.size <= 2
    val isScalene = uniqueSideLengths.size == 3
}