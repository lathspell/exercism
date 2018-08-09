// changed: removed unused variable "abc"
// changed: using "run()" to get rid of temporary variable and "return"
class Pangram {
    companion object {

        fun isPangram(s: String): Boolean =
                s.toLowerCase().run {
                    ('a'..'z').all { c -> contains(c) }
                }
    }
}