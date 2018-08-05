import java.util.*

object Sieve {

    fun primesUpTo(n: Int): List<Int> {
        val possiblePrimes = TreeMap((2..n).associate { it to true })
        for (cand in possiblePrimes.keys) {
            (2..n / cand).forEach {
                possiblePrimes[cand * it] = false
            }
        }
        return possiblePrimes.filter { it.value == true }.keys.toList()
    }

}