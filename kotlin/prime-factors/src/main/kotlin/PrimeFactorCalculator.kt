object PrimeFactorCalculator {

    fun primeFactors(n: Int): List<Int> = primeFactorsLong(n.toLong()).map { it.toInt() }

    fun primeFactors(n: Long): List<Long> = primeFactorsLong(n)

    private tailrec fun primeFactorsLong(n: Long, i: Long = 2, factors: List<Long> = listOf()): List<Long> = when {
        (n <= 1) -> factors
        n % i == 0L -> primeFactorsLong(n / i, i, factors + listOf(i))
        else -> primeFactorsLong(n, i + 1, factors)
    }

}