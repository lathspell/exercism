// changed: switched from single-line to "when" as seen in GeekTeam's solution as it's easier to grasp
class Year(private val year: Int) {

    val isLeap: Boolean = when {
            year % 400 == 0 -> true
            year % 100 == 0 -> false
            year % 4 == 0 -> true
            else -> false
        }
}