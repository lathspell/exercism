object SpiralMatrix {
    private enum class Direction {
        LEFT, RIGHT, UP, DOWN
    }

    fun ofSize(n: Int): Array<IntArray> {
        val matrix = (1..n).map { IntArray(n) }.toTypedArray()

        var x = 0
        var y = 0
        var dir = Direction.RIGHT
        var spiralOffset = 0

        (1..n * n).forEach { i ->
            matrix[y][x] = i
            when {
                dir == Direction.RIGHT && (x == n - spiralOffset - 1) -> {
                    dir = Direction.DOWN
                    y++
                }
                dir == Direction.RIGHT -> x++
                dir == Direction.DOWN && (y == n - spiralOffset - 1) -> {
                    dir = Direction.LEFT
                    x--
                }
                dir == Direction.DOWN -> y++
                dir == Direction.LEFT && (x == spiralOffset) -> {
                    dir = Direction.UP
                    y--
                    spiralOffset++
                }
                dir == Direction.LEFT -> x--
                dir == Direction.UP && (y == spiralOffset) -> {
                    dir = Direction.RIGHT
                    x++
                }
                dir == Direction.UP -> y--
            }
        }
        return matrix
    }
}
