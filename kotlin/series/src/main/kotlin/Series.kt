// changed: Switched to windowed() as seen in colintheshots's solution.
object Series {
    fun slices(n: Int, s: String): List<List<Int>> = s.map { it - '0' }.windowed(n)
}
