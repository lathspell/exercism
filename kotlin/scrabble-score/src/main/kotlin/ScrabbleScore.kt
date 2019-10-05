// changed: Replaced map property by "when" construct as seen in "encounter"'s solution
// changed: use object instead of class and companion object
object ScrabbleScore {

    fun scoreWord(s: String) = s
            .toUpperCase()
            .sumBy {
                when (it) {
                    in "AEIOULNRST" -> 1
                    in "DG" -> 2
                    in "BCMP" -> 3
                    in "FHVWY" -> 4
                    in "K" -> 5
                    in "JX" -> 8
                    in "QZ" -> 10
                    else -> 0
                }
            }
}
