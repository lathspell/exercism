// changed: removed unused variable "abc"
// changed: using "run()" to get rid of temporary variable and "return"
class Pangram {

    companion object {
        fun isPangram(s: String): Boolean =
                s.toLowerCase().run {
                    ('a'..'z').all { c -> contains(c) }
                }

        // works but looks not very functional
        fun isPangram3(s: String): Boolean {
            val hits = ('a'..'z').associateWith { false }.toMutableMap()
            s.toLowerCase().forEach { hits[it] = true }
            return hits.none { !it.value }
        }

        // works but algorithm does too much
        fun isPangram2(s: String): Boolean {
            return s.toLowerCase().filterNot { it < 'a' || it > 'z' }.toList().sorted().distinct() == ('a'..'z').toList()
        }
    }
}
