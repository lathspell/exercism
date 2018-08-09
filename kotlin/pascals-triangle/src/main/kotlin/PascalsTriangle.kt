// My favourite solution is that of "cowlike"
object PascalsTriangle {

    fun computeTriangle(rows: Int) = computeTriangle_cowlike(rows)

    fun computeTriangle_mine(rows: Int): List<List<Int>> = when {
        rows < 0 -> throw IllegalArgumentException("Rows can't be negative!")
        rows == 0 -> listOf()
        rows == 1 -> listOf(listOf(1))
        else -> {
            val above = computeTriangle(rows - 1)
            val lastLine = above[above.size - 1]
            val thisLine = (0 until rows).map {
                (if (it - 1 == -1) 0 else lastLine[it - 1]) + (if (it == rows - 1) 0 else lastLine[it])
            }
            above.plusElement(thisLine)
        }
    }

    // my favourite from "cowlike"
    fun computeTriangle_cowlike(rows: Int): List<List<Int>> {
        require(rows >= 0) { "Rows can't be negative!" }
        return generateSequence(listOf(1)) { prev ->
            listOf(1) + prev.windowed(2).map { it.sum() } + listOf(1)
        }.take(rows).toList()
    }

}