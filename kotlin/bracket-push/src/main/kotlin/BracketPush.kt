object BracketPush {
    private val pairs = mapOf('}' to '{', ']' to '[', ')' to '(')

    fun isValid(s: String): Boolean =
            s.fold(listOf<Char>()) { stack, c ->
                when (c) {
                    in "{[(" -> stack + c
                    in "}])" -> if (!stack.isEmpty() && stack.last() == pairs[c]) stack.subList(0, stack.size - 1) else return false
                    else -> stack
                }
            }.isEmpty()
}
