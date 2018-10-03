class IsbnVerifier {
    fun isValid(isbn: String): Boolean = isbn
            .filter { it.isDigit() || it == 'X' }
            .apply { if (indexOf('X') !in listOf(-1, 9)) return false }
            .apply { if (length != 10) return false }
            .map { if (it == 'X') 10 else Character.getNumericValue(it) }
            .foldIndexed(0) { pos, x, digitValue -> x + (10 - pos) * digitValue }
            .rem(11) == 0
}
