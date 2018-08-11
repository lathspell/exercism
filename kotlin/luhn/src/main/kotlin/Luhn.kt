// changed: now using isWhitespace() and isDigit()
// changed: now using apply{} to get a nice function chain
// changed: using foldIndexed() as seen in Hondough's solution
class Luhn {
    companion object {
        fun isValid(s: String) = s
                .filterNot { it.isWhitespace() }
                .apply {
                    if (length <= 1) return false
                    if (any { !it.isDigit() }) return false
                }
                .map { Character.getNumericValue(it) }
                .reversed()
                .foldIndexed(0) { index, acc, x ->
                    acc + when {
                        index % 2 == 0 -> x
                        x < 5 -> x * 2
                        else -> x * 2 - 9
                    }
                } % 10 == 0
    }
}
