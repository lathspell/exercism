// changed: if+throw to require
class Hamming {
    companion object {
        fun compute(a: String, b: String): Int {
            require(a.length == b.length) { "left and right strands must be of equal length." }
            return (0 until a.length).count { a[it] != b[it] }
        }

    }
}