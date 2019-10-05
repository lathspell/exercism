enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int): Classification {
    require(n > 0) { "Number must be natural!" }
    val sum = (1..n / 2).filter { n % it == 0 }.sum()
    return when {
        sum > n -> Classification.ABUNDANT
        sum < n -> Classification.DEFICIENT
        else -> Classification.PERFECT
    }
}
