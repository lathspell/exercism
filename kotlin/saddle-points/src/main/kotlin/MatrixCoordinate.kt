data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val matrix: List<List<Int>>) {

    val saddlePoints
        get() = (0 until matrix.size)
                .filter { y -> !matrix[y].isEmpty() }
                .flatMap { y ->
                    val maxValue = biggestValueHorizontally(y)
                    (0 until matrix[y].size)
                            .filter { x -> matrix[y][x] == maxValue }
                            .filter { x -> isBiggestVertical(x, maxValue) }
                            .map { x ->
                                MatrixCoordinate(y, x)
                            }
                }.toSet()

    private fun biggestValueHorizontally(y: Int): Int = matrix[y].max()!!

    private fun isBiggestVertical(x: Int, value: Int) = (0 until matrix.size).none { y -> matrix[y][x] < value }

}