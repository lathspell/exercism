// changed: Replaced the filter before split() by a notEmpty filter after split() as it's more
//          readable and split() eats all separator chars.
// There's an even shorter version in Lidonis's solution!
object WordCount {
    fun phrase(s: String): Map<String, Int> = s
            .toLowerCase()
            .split(Regex("[^a-z0-9']+"))
            .filter { it.isNotEmpty() }
            .map { it.trim('\'') }
            .groupBy { it }
            .mapValues { it.value.size }
}
