class Anagram(private val orig: String) {
    private val lowerOrig = orig.toLowerCase()
    private val sortedOrig = lowerOrig.toCharArray().sorted().joinToString("")

    fun match(cand: String): Boolean {
        if (sortedOrig.length != cand.length) {
            return false
        }
        val lowerCand = cand.toLowerCase()
        if (lowerOrig == lowerCand) {
            return false
        }
        val sortedCand = lowerCand.toCharArray().sorted().joinToString("")
        return sortedOrig == sortedCand
    }


    fun match(candidates: List<String>): Set<String> = candidates.filter { println("** filtering $it"); match(it) }.toSet()
}