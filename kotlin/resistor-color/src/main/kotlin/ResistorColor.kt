object ResistorColor {

    private val codes = mapOf(
            "black" to 0,
            "brown" to 1,
            "red" to 2,
            "orange" to 3,
            "yellow" to 4,
            "green" to 5,
            "blue" to 6,
            "violet" to 7,
            "grey" to 8,
            "white" to 9
    )

    fun colorCode(input: String): Int {
        return codes[input]!!
    }

    fun colors(): List<String> {
        return codes.keys.toList()
    }

}
