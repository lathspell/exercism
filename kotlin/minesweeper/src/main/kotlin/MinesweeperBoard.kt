class MinesweeperBoard(private val board: List<String>) {

    fun withNumbers(): List<String> =
            board.mapIndexed { y, row ->
                row.mapIndexed { x, cell ->
                    if (cell == '*') '*' else '0' + peekAround(x, y)
                }.joinToString("").replace('0', ' ')
            }

    private fun peekAround(x: Int, y: Int): Int =
            (-1..1).flatMap { dx ->
                (-1..1).map { dy ->
                    peek(x + dx, y + dy)
                }
            }.sum()

    private fun peek(x: Int, y: Int): Int = when {
        x !in 0 until board[0].length -> 0
        y !in 0 until board.size -> 0
        board[y][x] == '*' -> 1
        else -> 0
    }

}