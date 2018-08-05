class Year(private val year: Int) {

    val isLeap: Boolean
        get() = isMod(4) and ((isMod(400)) or (!isMod(100)))

    private fun isMod(other: Int) = ((year % other) == 0)

}