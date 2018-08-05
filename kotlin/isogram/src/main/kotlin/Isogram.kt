class Isogram {
    companion object {
        fun isIsogram(s: String): Boolean {
            val set = mutableSetOf<Char>()
            return s.toLowerCase().filter { it != ' ' && it != '-' }.all { set.add(it) }
        }
    }
}