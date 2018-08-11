class Anagram(private val orig: String) {

    private val lowerOrig = orig.toLowerCase()
    private val sortedOrig = lowerOrig.toCharArray().sorted()

    fun match(candidates: List<String>): Set<String> = candidates
            .filter { it.toLowerCase() != lowerOrig }
            .filter { it.toLowerCase().toCharArray().sorted() == sortedOrig }
            .toSet()
}