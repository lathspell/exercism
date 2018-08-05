class HandshakeCalculator {
    companion object {

        fun calculateHandshake(i: Int) = mutableListOf<Signal>().apply {
            when {
                i and 1 == 1 -> add(Signal.WINK)
                i and 2 == 1 -> add(Signal.DOUBLE_BLINK)
                i and 4 == 1 -> add(Signal.CLOSE_YOUR_EYES)
                i and 8 == 1 -> add(Signal.JUMP)
                i and 16 == 1 -> reverse()
            }
        }
    }

    fun calculateHandshakeV1(i: Int): List<Signal> {
        fun hasDigit(bit: Int) = (i shr bit) and 1 == 1
        val signals = mutableListOf<Signal>()
        if (hasDigit(0)) signals.add(Signal.WINK)
        if (hasDigit(1)) signals.add(Signal.DOUBLE_BLINK)
        if (hasDigit(2)) signals.add(Signal.CLOSE_YOUR_EYES)
        if (hasDigit(3)) signals.add(Signal.JUMP)
        if (hasDigit(4)) signals.reverse()
        return signals
    }
}
