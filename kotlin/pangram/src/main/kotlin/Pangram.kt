class Pangram {
    companion object {

        private val abc = listOf("a".."z")

        fun isPangram(s: String): Boolean {
            val lower = s.toLowerCase()
            return ('a'..'z').all { lower.contains(it) }
        }
    }
}