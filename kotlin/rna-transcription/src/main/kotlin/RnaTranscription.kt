fun transcribeToRna(dna: String): String {
    val map = mapOf('G' to 'C', 'C' to 'G', 'T' to 'A', 'A' to 'U')
    return dna.map { it -> map[it] }.joinToString("")
}
