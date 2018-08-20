class ChangeCalculator(private val coins: List<Int>) {

    fun computeMostEfficientChange(n: Int): List<Int> {
        require(n >= 0) { "Negative totals are not allowed." }
        val result = calc(n, emptyList(), n, coins.size - 1, n / coins[0] + 1)
        require(result.sum() == n) { "The total $n cannot be represented in the given currency." }
        return result
    }

    fun calc(origAmount: Int, path: List<Int>, amount: Int, coinIter: Int, maxPath: Int): List<Int> {
        if (coinIter < 0) return path
        val coin = coins[coinIter]

        var result = listOf<Int>()
        var newMaxPath = maxPath
        for (numCoins in (amount / coin) downTo 0) {

            val newAmount = amount - numCoins * coin
            if (newAmount < 0) break

            val newCoins = (1..numCoins).map { coin }
            if (path.size + newCoins.size > maxPath) break;

            val returned = calc(origAmount, path + newCoins, newAmount, coinIter - 1, newMaxPath)

            if (returned.sum() == origAmount && newMaxPath > returned.size) {
                newMaxPath = returned.size
                result = returned.sorted()
            }
        }
        return result
    }

}
