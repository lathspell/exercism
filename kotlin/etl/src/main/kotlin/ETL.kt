// changed: map+fold to flatMap as seen in amitsk's solution
object ETL {
    fun transform(old: Map<Int, List<Char>>): Map<Char, Int> =
            old.flatMap { (score, chars) -> chars.map { it.toLowerCase() to score } }.toMap()
}