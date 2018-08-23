// changed: Use init+require as seen in GrahamLea's solution
// changed: Replaced nested for loops by windowed() as seen in yo7's solution
// changed: Replaced sortDescending()+first() by max() as seen in swatteau's solution
class Series(private val series: String) {

    init {
        require(series.all { it.isDigit() }) { "Not only numbers!" }
    }

    fun getLargestProduct(span: Int) =
            when {
                span == 0 -> 1
                span > series.length -> throw IllegalArgumentException("Span larger than numbers!")
                else -> series
                        .windowed(span)
                        .map { window ->
                            window.fold(1) { acc, it ->
                                acc * Character.getNumericValue(it)
                            }
                        }
                        .max()
            }
}
