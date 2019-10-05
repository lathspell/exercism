class Hamming {
    companion object {

        fun compute(a: String, b: String): Int {
            require(a.length == b.length) { "left and right strands must be of equal length." }
            return a.indices.count { a[it] != b[it] }
        }

        // works, too
        fun compute3(a: String, b: String): Int {
            require(a.length == b.length) { "left and right strands must be of equal length." }
            return a.filterIndexed { i, c -> b[i] == c }.count()
        }

        // works but I find the !it not very readable
        fun compute2(a: String, b: String): Int {
            require(a.length == b.length) { "left and right strands must be of equal length." }
            return a.mapIndexed { i, c -> b[i] == c }.count { !it }
        }
    }
}
