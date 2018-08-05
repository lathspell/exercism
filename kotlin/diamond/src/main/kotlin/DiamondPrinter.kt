class DiamondPrinter {

    fun printToList(target: Char) = (('A' until target) + (target downTo 'A'))
            .map {letter->
                val width = 2 * (target - 'A' + 1) - 1
                (0 until width).map {column ->
                    when (column) {
                        width / 2 -  (letter - 'A') -> letter
                        width / 2 +  (letter - 'A') -> letter
                        else -> " "
                    }
                }.joinToString("")
            }
}
