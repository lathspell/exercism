object WordCount {
    fun phrase(s: String) : Map<String, Int> {
        s.split("\W").assgroupByTo(mutableMapOf<String, Int>(), it)



        return mapOf("foo" to 42)
    }
}