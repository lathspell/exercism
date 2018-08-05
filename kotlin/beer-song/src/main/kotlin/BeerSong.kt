class BeerSong {
    companion object {
        fun verses(start: Int, stop: Int): String {
            fun calcNr(i: Int) = if (i == 0) "no more" else "$i"
            fun calcBottles(i: Int) = if (i == 1) "bottle" else "bottles"
            return (start downTo stop).map { nr ->
                val nrBefore = calcNr(nr)
                val nrAfter = calcNr(nr - 1)
                val bottlesBefore = calcBottles(nr)
                val bottlesAfter = calcBottles(nr - 1)
                val oneOrIt = if (nr == 1) "it" else "one"
                when (nr) {
                    0 -> "${nrBefore.capitalize()} bottles of beer on the wall, $nrBefore bottles of beer.\n" +
                            "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
                    else -> "$nr $bottlesBefore of beer on the wall, $nr $bottlesBefore of beer.\n" +
                            "Take $oneOrIt down and pass it around, $nrAfter $bottlesAfter of beer on the wall.\n"
                }
            }.joinToString("\n")
        }
    }
}