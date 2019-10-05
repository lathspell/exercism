class Acronym {
    companion object {
        fun generate(s: String) = s
                .splitToSequence(" ", "-")
                .map { it[0].toUpperCase() }
                .joinToString("")

        // works for any separator not only space and dash
        fun generate2(s: String) = s
                .toUpperCase()
                .split(Regex("[^A-Z]"))
                .filter { it -> it.any { it2 -> it2 in 'A'..'Z'}  }
                .map { it[0] }
                .joinToString("")
    }
}
