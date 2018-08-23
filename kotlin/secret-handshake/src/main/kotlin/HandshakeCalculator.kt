object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> = mutableListOf<Signal>().apply {
        if (i and 1 == 1) add(Signal.WINK)
        if (i and 2 == 2) add(Signal.DOUBLE_BLINK)
        if (i and 4 == 4) add(Signal.CLOSE_YOUR_EYES)
        if (i and 8 == 8) add(Signal.JUMP)
        if (i and 16 == 16) reverse()
    }
}

