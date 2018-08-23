// changed: Learned List<*> notation from Lidonis's solution. No need for List<Any?>!
object Flattener {

    fun flatten(list: List<*>): List<Int> =
            list.flatMap {
                when (it) {
                    is Int -> listOf(it)
                    is List<*> -> flatten(it)
                    else -> emptyList()
                }
            }
}