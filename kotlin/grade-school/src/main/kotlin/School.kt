// This should cover the bonus task as well as roster is private and
// db(), sort() and grade() only declares immutable Map and List
class School {
    private val roster = sortedMapOf<Int, MutableList<String>>()

    fun db(): Map<Int, List<String>> = roster

    fun grade(n: Int): List<String> = roster.getOrDefault(n, mutableListOf())

    fun add(name: String, grade: Int) = roster.getOrPut(grade) { mutableListOf() }.add(name)

    fun sort(): Map<Int, List<String>> = roster.mapValues { it.value.sorted() }
}
