object Atbash {

    fun encode(s: String) = s.mapNotNull { translateChar(it) }
            .chunked(5)
            .fold("") { result, chunk -> result + chunk.joinToString("") + " " }
            .trim()

    fun decode(s: String): String = s.mapNotNull { translateChar(it) }.joinToString("")

    private fun translateChar(c: Char) = when (c) {
        in 'a'..'z' -> ('z' - (c - 'a'))
        in 'A'..'Z' -> ('z' - (c - 'A'))
        in '0'..'9' -> c
        else -> null
    }
}