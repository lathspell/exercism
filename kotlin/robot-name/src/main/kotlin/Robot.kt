// changed: Using shuffle() instead of Random(); understood that reset() should only reset the instances name not the register
class Robot {

    companion object {
        private val register = mutableSetOf<String>()

        private fun genName() = (('A'..'Z').shuffled().subList(0, 2)
                + ('0'..'9').shuffled().subList(0, 3))
                .joinToString("")

        private fun genGloballyUniqueName() = generateSequence { genName() }.first { register.add(it) }
    }

    var name: String = genGloballyUniqueName()

    fun reset() {
        name = genGloballyUniqueName()
    }
}