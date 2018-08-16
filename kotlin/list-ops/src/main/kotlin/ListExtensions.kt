// Only the following existing List functions were used:
// - constructor
// - add()
// - get() or []
// - foreach()

fun <T> List<out T>.customAppend(list: List<T>): List<T> {
    var result = mutableListOf<T>()
    this.forEach {
        result.add(it)
    }
    list.forEach {
        result.add(it)
    }
    return result
}

fun <T> List<List<out T>>.customConcat(): List<T> {
    var result = mutableListOf<T>()
    this.forEach { subList ->
        subList.forEach { result.add(it) }
    }
    return result
}

fun <T> List<out T>.customReverse(): List<T> {
    var result = mutableListOf<T>()
    for (i in customSize - 1 downTo 0) {
        result.add(this[i])
    }
    return result
}

fun <T> List<out T>.customFilter(lambda: (it: T) -> Boolean): List<T> {
    var result = mutableListOf<T>()
    this.forEach {
        if (lambda(it)) result.add(it)
    }
    return result
}

fun <T, R> List<out T>.customMap(lambda: (it: T) -> R): List<R> {
    var result = mutableListOf<R>()
    this.forEach {
        result.add(lambda(it))
    }
    return result
}

fun <T, R> List<out T>.customFoldLeft(acc: R, lambda: R.(T) -> R): R {
    var result = acc
    this.forEach {
        result = result.lambda(it)
    }
    return result
}

fun <T, R> List<out T>.customFoldRight(acc: R, lambda: T.(R) -> R): R {
    var result = acc
    this.customReverse().forEach {
        result = it.lambda(result)
    }
    return result
}

val <T> List<T>.customSize: Int
    get() {
        var i = 0
        this.forEach { i++ }
        return i
    }



