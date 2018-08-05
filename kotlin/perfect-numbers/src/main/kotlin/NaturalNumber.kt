enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(n: Int): Classification {
    if (n <= 0) throw RuntimeException("negative number")
    val sum = (n / 2 downTo 1).filter { (n % it) == 0 }.sum()
    return when {
        sum > n -> Classification.ABUNDANT
        sum < n -> Classification.DEFICIENT
        else -> Classification.PERFECT
    }
}
