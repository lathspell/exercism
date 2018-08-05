class Raindrops {
    companion object {
        fun convert(n: Int): String {
            var result = ""
            if ((n % 3) == 0) result += "Pling"
            if ((n % 5) == 0) result += "Plang"
            if ((n % 7) == 0) result += "Plong"
            return if (result.isBlank()) n.toString() else result
        }
    }
}