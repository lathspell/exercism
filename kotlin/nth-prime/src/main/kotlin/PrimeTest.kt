// change: Used "tailrec" as seen in GrahamLea's version
// change: Replaced n/2 by sqrt(n) as seen at GrahamLeas' version
// change: Removed nonPrimesCache as there was no benefit for simple tests
object Prime {

    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }
        return generateSequence(2) { nextPrime(it + 1) }.take(n).last()
    }

    // A "tail recursion" function is optimized by the compiled into a while loop.
    // We gain the concise coding style without the danger of stack overflows.
    // Endless loops are still possible though. Tested it. :)
    private tailrec fun nextPrime(n: Int): Int = if (isPrime(n)) n else nextPrime(n + 1)

    // "inline" copies the code into the calling function. Saves some function calls
    // but makes the class file bigger. No measurable effect for simple tests though.
    private inline fun isPrime(n: Int): Boolean {
        return when {
            n < 2 -> false
            n == 2 -> true
            n and 1 == 0 -> false
            else -> (2..Math.sqrt(n.toDouble()).toInt()).none { n % it == 0 }
        }
    }
}