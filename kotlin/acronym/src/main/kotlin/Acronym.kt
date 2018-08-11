class Acronym {
    companion object {
        fun generate(s: String) = s
                .splitToSequence(" ", "-")
                .map { it[0].toUpperCase() }
                .joinToString("")
    }
}