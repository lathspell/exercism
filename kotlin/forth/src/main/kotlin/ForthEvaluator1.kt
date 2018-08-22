import java.util.*

// Primitive solution in one big function and custom operators using string replace.
class ForthEvaluator1 {

    fun evaluateProgram(lines: List<String>): List<Int> {
        val customOps = mutableMapOf<String, String>()
        val customOpsRegex = Regex(""":\s*(\S+)\s+(.+)\s+;""")
        val stack = ArrayDeque<Int>()
        for (line in lines) {
            val customOpsMatcher = customOpsRegex.matchEntire(line)
            if (customOpsMatcher != null) {
                val (cmd, tokens) = customOpsMatcher.destructured
                require(!cmd.matches(Regex("""\d+"""))) { "Cannot redefine numbers" }
                customOps += cmd to tokens
            } else {
                val customLine = customOps.entries.fold(line) { _, (k, v) -> line.replace(k, v) }
                val tokens = customLine.split(Regex("""\s+"""))
                for (origToken in tokens) {
                    val token = origToken.toLowerCase()
                    when {
                        token.matches(Regex("""\d+""")) -> stack.push(token.toInt())
                        token == "+" -> {
                            require(stack.size >= 2) { "Addition requires that the stack contain at least 2 values" }
                            stack.push(stack.pop() + stack.pop())
                        }
                        token == "-" -> {
                            require(stack.size >= 2) { "Subtraction requires that the stack contain at least 2 values" }
                            val last = stack.pop(); stack.push(stack.pop() - last)
                        }
                        token == "/" -> {
                            require(stack.size >= 2) { "Division requires that the stack contain at least 2 values" }
                            val last = stack.pop();
                            require(last != 0) { "Division by 0 is not allowed" }
                            stack.push(stack.pop() / last)
                        }
                        token == "*" -> {
                            require(stack.size >= 2) { "Multiplication requires that the stack contain at least 2 values" }
                            stack.push(stack.pop() * stack.pop())
                        }
                        token == "dup" -> {
                            require(stack.isNotEmpty()) { "Duplicating requires that the stack contain at least 1 value" }
                            stack.push(stack.peek())
                        }
                        token == "drop" -> {
                            require(stack.isNotEmpty()) { "Dropping requires that the stack contain at least 1 value" }
                            stack.pop()
                        }
                        token == "swap" -> {
                            require(stack.size >= 2) { "Swapping requires that the stack contain at least 2 values" }
                            val first = stack.pop()
                            val second = stack.pop()
                            stack.push(first)
                            stack.push(second)
                        }
                        token == "over" -> {
                            require(stack.size >= 2) { "Overing requires that the stack contain at least 2 values" }
                            val first = stack.pop()
                            val second = stack.pop()
                            stack.push(second)
                            stack.push(first)
                            stack.push(second)
                        }
                        else -> throw IllegalArgumentException("No definition available for operator \"$origToken\"")
                    }
                }
            }
        }
        return stack.reversed()
    }
}