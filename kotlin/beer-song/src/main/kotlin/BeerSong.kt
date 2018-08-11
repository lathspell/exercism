// changed: Added "when 1" case to get rid of all the temporary variables
class BeerSong {
    companion object {
        fun verses(start: Int, stop: Int) =
                (start downTo stop).joinToString("\n") { nr ->
                    when (nr) {
                        0 -> "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
                        1 -> "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                                "Take it down and pass it around, no more bottles of beer on the wall.\n"
                        else -> "$nr bottles of beer on the wall, $nr bottles of beer.\n" +
                                "Take one down and pass it around, ${nr - 1} bottle${if (nr - 1 == 1) "" else "s"} of beer on the wall.\n"
                    }
                }
    }
}