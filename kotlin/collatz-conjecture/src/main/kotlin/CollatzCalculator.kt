object CollatzCalculator {

    // Improved using GrahamLea's solution: generateSequence() and require()
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

    fun computeStepCount_v1(n: Int): Int {
        if (n < 1) throw IllegalArgumentException("Only natural numbers are allowed")
        var round = 0;
        var x = n
        while (x > 1) {
            x = when {
                x % 2 == 0 -> x / 2;
                else -> 3 * x + 1
            }
            round++
        }
        return round;
    }
}