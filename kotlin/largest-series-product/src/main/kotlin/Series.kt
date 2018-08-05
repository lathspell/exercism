class Series(private val series: String) {

    private val numbers =
            series.apply {
                if (contains("[^0-9]".toRegex())) throw IllegalArgumentException("Not only numbers!")
            }.toList().map { Character.getNumericValue(it) }

    fun getLargestProduct(span: Int) =
            when {
                span < 0 -> throw IllegalArgumentException("Span is negative!")
                span == 0 -> 1
                span > numbers.size -> throw IllegalArgumentException("Span larger than numbers!")
                else ->
                    (0..(numbers.size - span)).map { pos ->
                        var product = numbers[pos]
                        (1 until span).forEach { offset ->
                            product *= numbers[pos + offset]
                        }
                        product
                    }.sortedDescending().first()
            }
}
