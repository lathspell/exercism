// changed: switched from single-line to "when" as seen in GeekTeam's solution as it's easier to grasp
class Year(private val year: Int) {

    val isLeap: Boolean
        get() = when {
            isMod(400) -> true
            isMod(100) -> false
            isMod(4) -> true
            else -> false
        }

    private fun isMod(other: Int) = ((year % other) == 0)

}