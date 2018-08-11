import java.util.*

class Robot {

    companion object {
        private val register = mutableSetOf<String>()
        private val abc = ('A'..'Z').toList()
        private val digits = ('0'..'9').toList()
        private fun rnd(list: List<Char>) = list[Random().nextInt(list.size - 1)]
        private fun genName(): String = ((1..2).map { rnd(abc) } + (1..3).map { rnd(digits) }).joinToString("")
    }

    val name: String
        get() = generateSequence { genName() }
                .first {
                    register.add(it)
                }

    fun reset() = register.clear()

}