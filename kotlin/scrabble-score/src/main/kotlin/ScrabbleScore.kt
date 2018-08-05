class ScrabbleScore {

    companion object {
        private val points = (
                listOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T').map { it to 1 } +
                        listOf('D', 'G').map { it to 2 } +
                        listOf('B', 'C', 'M', 'P').map { it to 3 } +
                        listOf('F', 'H', 'V', 'W', 'Y').map { it to 4 } +
                        listOf('K').map { it to 5 } +
                        listOf('J', 'X').map { it to 8 } +
                        listOf('Q', 'Z').map { it to 10 }
                ).toMap()

        fun scoreWord(s: String) = s.toUpperCase().toCharArray().sumBy { points[it]!! }
    }
}
