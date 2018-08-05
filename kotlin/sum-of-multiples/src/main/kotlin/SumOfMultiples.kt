class SumOfMultiples {
    companion object {
        fun sum(numbers: Set<Int>, max: Int) =
                numbers.flatMap { nr ->
                    (1 until max).filter { (it % nr) == 0 }
                }.toSet().sum()
    }
}