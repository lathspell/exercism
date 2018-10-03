class RailFenceCipher(private var numRails: Int) {

    fun getEncryptedData(s: String): String {
        val matrix = Array(numRails) { arrayOfNulls<Char>(s.length) }

        var rail = 0
        var dir = -1
        s.forEachIndexed { i, c ->
            matrix[rail][i] = c

            if (rail == numRails - 1 || rail == 0) dir = -dir
            rail += dir
        }
        return matrix.flatMap { it.filterNotNull() }.joinToString("")
    }

    fun getDecryptedData(s: String): String {
        val matrix = Array(numRails) { arrayOfNulls<Char>(s.length) }

        // create template
        var rail = 0
        var dir = -1
        s.indices.forEach { i ->
            matrix[rail][i] = '?'

            if (rail == numRails - 1 || rail == 0) dir = -dir
            rail += dir
        }

        // fill template
        var i = 0
        for (rail in 0 until matrix.size) {
            for (column in 0 until matrix[rail].size) {
                if (matrix[rail][column] == '?') {
                    matrix[rail][column] = s[i++]
                }
            }
        }

        // read plaintext
        rail = 1
        dir = -1
        return s.indices.map { i ->
            if (rail == numRails-1 || rail == 0) dir = -dir
            rail += dir
            matrix[rail][i]
        }.joinToString("")
    }
}