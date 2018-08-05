class Luhn {
    companion object {
        fun isValid(s: String): Boolean {
            val nospaces = s.toList().filter { it != ' ' }
            if (nospaces.size <= 1 || !nospaces.all { it in '0'..'9' }) {
                return false
            }

            val numbers = nospaces.map(Character::getNumericValue).toMutableList()
            (numbers.size - 2 downTo 0 step  2).forEach {
                val twice = numbers[it] * 2
                numbers[it] = if (twice > 9) (twice - 9) else twice
            }

            return numbers.sum() % 10 == 0
        }
    }
}