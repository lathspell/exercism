object RomanNumeral {

    private val reversedMap = mapOf(
            1 to "I",
            4 to "IV",
            5 to "V",
            9 to "IX",
            10 to "X",
            40 to "XL",
            50 to "L",
            90 to "XC",
            100 to "C",
            400 to "CD",
            500 to "D",
            900 to "CM",
            1000 to "M").entries.reversed()

    fun value(n: Int): String = buildString {
        reversedMap.fold(n) { remainder, entry ->
            val quotient = remainder / entry.key
            append(entry.value.repeat(quotient))
            remainder - quotient * entry.key
        }
    }

}