// changed: syncronized(), @Synchronized, AtomicIntegers, Actors - there are so many cool solutions!
//          I switched to @Synchronized as seen in oliveiradev's solution as it seems the most readable.
// changed: Learned check() from geoffwa's solution
class BankAccount {

    var balance: Int = 0
        get() {
            check(isOpen)
            return field
        }
        private set

    private var isOpen = true

    fun close() {
        isOpen = false
    }

    @Synchronized
    fun adjustBalance(amount: Int) {
        check(isOpen)
        balance += amount
    }

}
