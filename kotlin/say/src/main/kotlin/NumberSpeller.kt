class NumberSpeller {
    fun say(n: Long): String {
        require(n >= 0) { "Input must be non-negative!" }
        require(n < 1000000000000) { "Input must be less than 1000000000000" }

        return when (n) {
            0L -> "zero"
            1L -> "one"
            2L -> "two"
            3L -> "three"
            4L -> "four"
            5L -> "five"
            6L -> "six"
            7L -> "seven"
            8L -> "eight"
            9L -> "nine"
            10L -> "ten"
            11L -> "eleven"
            12L -> "twelve"
            13L -> "thirteen"
            in 14L..19L -> say(n - 10) + "teen"
            in 20L..99L -> when (n) {
                20L -> "twenty"
                30L -> "thirty"
                40L -> "forty"
                50L -> "fifty"
                60L -> "sixty"
                70L -> "seventy"
                80L -> "eighty"
                90L -> "ninety"
                else -> say(n - (n % 10)) + "-" + say(n % 10)
            }
            in 100L..999L -> sayBigOne(n, 100, "hundred")
            in 1_000L..999_999L -> sayBigOne(n, 1_000, "thousand")
            in 1_000_000L..999_999_999L -> sayBigOne(n, 1_000_000, "million")
            else -> sayBigOne(n, 1_000_000_000, "billion")
        }
    }

    private fun sayBigOne(n: Long, base: Int, name: String): String {
        return say(n / base) +
                " " + name +
                if (n % base == 0L) "" else " " + say(n % base)
    }
}