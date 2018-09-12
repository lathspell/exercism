// changed: if+throw to require; class to object; indices instead of (0..a.length)
object Hamming {

    fun compute(a: String, b: String): Int {
        require(a.length == b.length) { "left and right strands must be of equal length." }
        return a.indices.count { a[it] != b[it] }
    }

}