class Year(private val year: Int) {
    val isLeap: Boolean = when {
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        year % 4 == 0 -> true
        else -> false
    }
}

// Works fine but maybe not so readable
class Year_oldschool(year: Int) {
    val isLeap: Boolean = (year % 4 == 0) and ((year % 100 != 0) or (year % 400 == 0))
}
