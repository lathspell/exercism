object Flattener {
    fun flatten(list: List<Any?>): List<Any?> =
            list.flatMap {
                when (it) {
                    null -> emptyList()
                    is Int -> listOf(it)
                    is List<*> -> flatten(it)
                    else -> throw IllegalArgumentException("Neither Int nor List: $it")
                }
            }
}