// changed: using generateSequence() and require() as seen in GrahamLea's solution
object CollatzCalculator {

    fun computeStepCount(start: Int): Int {
        require(start > 0) { "Only natural numbers are allowed" }
        return generateSequence(start) {n->
            when {
                n == 1 -> null
                n and 1 == 0 -> n / 2;
                else -> 3 * n + 1
            }
        }.count() - 1
    }
}