class Reactor<T> {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    inner class SimpleSubscription : Subscription {
        override fun cancel() {

        }
    }

    abstract inner class Cell<T> {
        abstract var value: T
    }

    inner class InputCell(n: T) : Cell<T>() {
        override var value = n
    }

    inner class ComputeCell<T>(private vararg val inputs: Cell<T>, private val lambda: (List<T>) -> T) : Cell<T>() {

        override var value: T = lambda(inputs.map { it.value })

        operator fun get(i: Int): T = inputs[i].value

        fun addCallback(lambda: (T) -> Unit): Subscription {
            return SimpleSubscription()
        }

    }
}