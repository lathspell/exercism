// changed: Replaced the filter before split() by a notEmpty filter after split() as it's more
//          readable and split() eats all separator chars.
// There's an even shorter version in Lidonis's solution!
object WordCount2 {
    fun phrase(s: String): Map<String, Int> = s
            .toLowerCase()
            .split(Regex("[^a-z0-9']+"))
            .filter { it.isNotEmpty() }
            .map { it.trim('\'') }
            .groupBy { it }
            .mapValues { it.value.size }
}

object WordCount {
    fun phrase(string: String): Map<String, Int> {
        val processed = string
                .toLowerCase()
                .replace(Regex("[^a-z0-9']"), " ")
        val words = processed
                .split(' ')
                .map { it.trim('\'') }
                .filter { it -> !it.trim().isEmpty() }

        return words.groupBy { it}

                .mapValues { it.value.size }
    }

}