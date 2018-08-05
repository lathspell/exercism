class Hamming {
    companion object {
        fun compute(a: String, b: String) =
                if (a.length == b.length)
                    (0 until a.length).count { a[it] != b[it] }
                else
                    throw IllegalArgumentException("left and right strands must be of equal length.")

    }
}