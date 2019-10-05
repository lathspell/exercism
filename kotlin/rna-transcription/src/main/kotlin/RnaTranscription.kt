import java.lang.IllegalArgumentException

fun transcribeToRna(s: String) : String {
    val mappings = mapOf('G' to 'C', 'A' to 'U', 'T' to 'A', 'C' to 'G')
    return s.map { mappings[it] }.joinToString("")
}

fun transcribeToRna_withCase(s: String) = s.map {
    when (it) {
        'G' -> 'C'
        'A' -> 'U'
        'T' -> 'A'
        'C' -> 'G'
        else -> throw IllegalArgumentException("Invalid character $it!")
    }
}.joinToString("")
