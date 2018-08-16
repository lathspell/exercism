// changed: Improved while() condition as seen in bugfry's solution
object BinarySearch {
    fun search(list: List<Int>, wanted: Int): Int {
        var start = 0
        var end = list.size - 1

        while (start <= end) {
            var middle = start + (end - start) / 2
            val x = list[middle]
            when {
                x == wanted -> return middle
                x > wanted -> end = middle - 1
                x < wanted -> start = middle + 1
            }
        }
        return -1
    }
}