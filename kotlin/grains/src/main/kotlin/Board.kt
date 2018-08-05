import java.math.BigInteger

class Board {

    companion object {

        fun getGrainCountForSquare(i: Int): BigInteger = when {
            i < 1 || i > 64 -> throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
            else -> BigInteger.valueOf(2).pow(i - 1)
        }

        // I thought too much on the language and too less on the problem. Thanks to yo7 for the inspiration :)
        fun getTotalGrainCount() = BigInteger.valueOf(2).pow(64) - BigInteger.ONE

        /*
        fun getTotalGrainCount_v1() = (1..64).map { getGrainCountForSquare(it) }.sum()
        private fun Iterable<BigInteger>.sum(): BigInteger {
            var sum = BigInteger.ZERO
            for (element in this) {
                sum += element
            }
            return sum
        }*/
    }
}