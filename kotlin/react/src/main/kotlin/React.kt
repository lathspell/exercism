// Credit for this goes to davethomas11!
// I gave up on this one but annotated his version while trying to learn from it.
// It's just beautiful and with originally only 42 lines the shortest one I found so far.
class Reactor<T> {

    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    // The base class for the cells. Has to be "inner" to have access to the type
    // "T" from its outer class Reactor.
    open inner class InputCell(private var n: T) {

        // Subscriptions are a list of lambda functions.
        // They are used to create ComputeCells but can also be used to update unrelated
        // variables from outside this class by adding lambda functions with addCallback().
        private var subscriptions: List<(T) -> Unit> = emptyList()

        // The tests demand that the subscribers should only be notified on changed values so we need two
        // variables, this as accessor/mutator and a backing variable ("n") to compare against.
        var value: T
            get() = n
            set(newValue) {
                if (n != newValue) {
                    n = newValue
                    subscriptions.forEach { it(newValue) }
                }
            }

        // New callback functions are simply added to the already existing list of subscriptions.
        // The trick here is that an anonymous object of type Subscription is created whose sole purpose is to
        // offer a method with which the provided callback function can be removed again. Functions, like classes,
        // have a hashCode() method and can thus be identified and found in the list of subscriptions.
        fun addCallback(lambda: (T) -> Unit): Subscription {
            subscriptions += lambda
            return object : Subscription {
                override fun cancel() {
                    subscriptions -= lambda
                }
            }
        }
    }

    // ComputeCells descend from InputCells to inherit their subscription capabilities.
    // The value of this cell has to be calculated during instantiation as it is required in the InputCell's constructor.
    inner class ComputeCell(
            private vararg val inputs: InputCell,
            private val lambda: (List<T>) -> T)
        : InputCell(lambda(inputs.map { it.value })) {

        // After the construction is complete, we register this ComputeCell as subscriber of all the given InputCells.
        // As ComputeCell inherits from InputCell it is possible to have ComputeCells depend on other ComputeCells!
        init {
            addCallbacks(inputs)
        }

        // The process of registering callbacks is put into a separate method as we use recursion in case one of
        // the inputs is a ComputeCell itself. The type of inputs is not list as it has to match the one that is
        // created by the "vararg" in the constructor.
        private fun addCallbacks(inputs: Array<out InputCell>): Unit =
                inputs.forEach {
                    if (it is ComputeCell) {
                        // If another ComputeCell asks to be added as subscriber, we simply add all of its inputs.
                        addCallbacks(it.inputs)
                    } else {
                        // We create an anonymous function that fetches the value of all our inputs,
                        // processes them with the lambda function that was provided to us in the constructor
                        // and then assigns the result as new value of this instance.
                        it.addCallback {
                            value = lambda(this.inputs.map { it.value })
                        }
                    }
                }
    }
}
