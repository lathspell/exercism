import java.util.*

// My first solution was 70 lines function and so easy that a BASIC programmer could read it.
// But it looked that way, too, and as the idea of a map of lambdas was spooking in my head
// from the beginning I gave it a second try :)
// So far it's the second shortest solution, beaten only by adamzk's solution which has a
// cool use of List.partition() but not such a nicely extensible command map.
class ForthEvaluator {

    private val ops = mutableMapOf(
            "+" to createOp("Addition", 0) { push(pop() + pop()) },
            "-" to createOp("Subtraction", 2) { val last = pop(); push(pop() - last) },
            "/" to createOp("Division", 2) {
                val last = pop();
                require(last != 0) { "Division by 0 is not allowed" }
                push(pop() / last)
            },
            "*" to createOp("Multiplication", 2) { push(pop() * pop()) },
            "dup" to createOp("Duplicating", 1) { push(peek()) },
            "drop" to createOp("Dropping", 1) { pop() },
            "swap" to createOp("Swapping", 2) {
                val pair = Pair(pop(), pop())
                push(pair.first)
                push(pair.second)
            },
            "over" to createOp("Overing", 2) { push(get(size - 2)) }
    )

    fun evaluateProgram(lines: List<String>): List<Int> {
        val stack = LinkedList<Int>()
        lines.forEach { line ->
            val tokens = line.split(" ")
            if (tokens.first() == ":") {
                val cmd = tokens.drop(1).first()
                require(cmd.toIntOrNull() == null) { "Cannot redefine numbers" }
                ops[cmd] = { runTokens(tokens.drop(2).dropLast(1), stack) }
            } else {
                runTokens(tokens, stack)
            }
        }
        return stack.reversed()
    }

    private fun runTokens(tokens: List<String>, acc: Deque<Int>) = tokens.forEach { token ->
        if (token.toIntOrNull() != null)
            acc.push(token.toInt());
        else
            acc.apply { ops.getOrElse(token) { throw IllegalArgumentException("No definition available for operator \"$token\"") } }
    }

    private fun createOp(name: String, needed: Int, lambda: LinkedList<Int>.() -> Unit) =
            fun LinkedList<Int>.() {
                require(size >= needed) { "$name requires that the stack contain at least $needed values" }
                lambda()
            }
}