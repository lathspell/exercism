// changed: Switched from "foreach" to "map+toMap" as seen in SophieKoonin's solution
// changed: Moved check from function into init() where it belongs
class Dna(private val dna: String) {

    init {
        require(dna.all {it in "ACGT" })
    }

    val nucleotideCounts: Map<Char, Int> =
            "ACGT".map { letter ->
                letter to dna.count { it == letter }
            }.toMap()
}
