package diffsquares

// effectively: (n + 1) * n / 2
func SquareOfSum(n int) (out int) {
	for i := 0; i <= n; i++ {
		out += i
	}
	return out * out
}

// effectively: (2*n + 1) * (n + 1) * n / 6
func SumOfSquares(n int) (out int) {
	for i := 0; i <= n; i++ {
		out += i * i
	}
	return
}

func Difference(n int) int {
	return SquareOfSum(n) - SumOfSquares(n)
}

/*
class Squares(private val nr: Int) {
    fun squareOfSum() = (1..nr).sum().let { it * it }
    fun sumOfSquares() = (1..nr).sumBy { it * it }
    fun difference() = squareOfSum() - sumOfSquares()
}
*/
