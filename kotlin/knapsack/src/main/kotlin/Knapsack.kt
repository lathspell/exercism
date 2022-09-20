data class Item(val weight: Int, val value: Int)

/**
 * Algorithm taken from https://rosettacode.org/wiki/Knapsack_problem/0-1#Kotlin
 * Tried to understand it but failed :-)
 */
fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    println("Max weight $maximumWeight; Items:\n" + items.indices.joinToString("\n") { "  i=$it  ${items[it]}" } + "\n")

    fun m(depth: Int, i: Int, w: Int): Triple<MutableList<Item>, Int, Int> {
        val prefix = " ".repeat(depth)
        println("$prefix m(i=$i, w=$w)")
        if (i < 0 || w == 0) {
            println("$prefix => null")
            return Triple(mutableListOf(), 0, 0)
        } else if (items[i].weight > w) {
            println("$prefix => item too heavy")
            return m(depth = depth + 1, i = i - 1, w = w)
        }
        val (l0, w0, v0) = m(depth = depth + 1, i = i - 1, w = w)
        var (l1, w1, v1) = m(depth = depth + 1, i = i - 1, w = w - items[i].weight)
        v1 += items[i].value
        if (v1 > v0) {
            l1.add(items[i])
            println("$prefix => added item i=$i ${items[i]}")
            return Triple(l1, w1 + items[i].weight, v1)
        }
        println("$prefix not adding item i=$i")
        return Triple(l0, w0, v0)
    }
    val (chosenItems, totalWeight, totalValue) = m(depth = 0, i = items.size - 1, w = maximumWeight)

    println("Knapsack Item Chosen    Weight Value")
    println("----------------------  ------ -----")
    println(chosenItems.sortedByDescending { it.value }.joinToString(separator = "\n"))
    println("----------------------  ------ -----")
    println("Total ${chosenItems.size} Items Chosen     $totalWeight   $totalValue\n")

    return totalValue
}
