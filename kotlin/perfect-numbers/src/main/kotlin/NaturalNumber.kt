enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int): Classification {
    require(n > 0)
    val sum = (n / 2 downTo 1).filter { n % it == 0 }.sum()
    return when {
        sum > n -> Classification.ABUNDANT
        sum < n -> Classification.DEFICIENT
        else -> Classification.PERFECT
    }
}



