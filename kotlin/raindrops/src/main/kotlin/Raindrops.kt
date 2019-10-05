class Raindrops {
    companion object {
        fun convert(n: Int) = buildString {
            if ((n % 3) == 0) append("Pling")
            if ((n % 5) == 0) append("Plang")
            if ((n % 7) == 0) append("Plong")
            if (isBlank()) append(n)
        }

        // works but not as nice as buildString()
        fun convert2(i: Int): String {
            fun checkFactor(i: Int, factor: Int, word: String) = if ((i % factor) == 0) word else ""
            val output = checkFactor(i, 3, "Pling") + checkFactor(i, 5, "Plang") + checkFactor(i, 7, "Plong")
            return if (output.isEmpty()) i.toString() else output
        }

    }
}
