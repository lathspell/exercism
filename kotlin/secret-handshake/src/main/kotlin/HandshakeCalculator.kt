object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> = mutableListOf<Signal>().apply {
        when {
            i and 1 == 1 -> add(Signal.WINK)
            i and 2 == 1 -> add(Signal.DOUBLE_BLINK)
            i and 4 == 1 -> add(Signal.CLOSE_YOUR_EYES)
            i and 8 == 1 -> add(Signal.JUMP)
            i and 16 == 1 -> reverse()
        }
    }
}
