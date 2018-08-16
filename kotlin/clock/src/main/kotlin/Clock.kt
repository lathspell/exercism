data class Clock(private var hours: Int = 0, private var minutes: Int = 0) {

    init {
        add(0)
    }

    override fun toString() = String.format("%02d:%02d", hours, minutes)

    fun add(addMinutes: Int) {
        val totalMins = hours * 60 + minutes + addMinutes
        val finalMins = totalMins umod 60
        hours = ((totalMins - finalMins) / 60) umod 24
        minutes = finalMins
    }

    private infix fun Int.umod(n: Int): Int {
        val r = this.rem(n)
        return if (r < 0) r + n else r
    }
}