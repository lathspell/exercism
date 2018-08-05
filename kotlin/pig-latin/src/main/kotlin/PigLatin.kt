// *** INCOMPLETE *** This is stupid...
class PigLatin {
    companion object {
        private val vowels = setOf("a", "e", "i", "o", "u", "yt")
        private val conclusters = setOf("y", "sm", "str", "st", "gk", "ch", "qu", "thr", "th", "yt", "sch", "xr")

        fun translate(s: String): String {

            fun startsWithVowel() = vowels.any { s.startsWith(it) }

            return when {

                startsWithVowel() -> s + "ay"

                conclusters.any { s.startsWith(it) } -> {
                    val cons = conclusters.first { s.startsWith(it) }
                    s.substring(cons.length) + cons + "ay"
                }

                s.length == 2 && s[1] == 'y' -> {
                    s.reversed() + "ay"
                }

                else -> s
            }
        }
    }
}