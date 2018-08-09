// changed: switched to buildString as seen in Nexcius's solution
class Raindrops {
    companion object {
        fun convert(n: Int) = buildString {
            if ((n % 3) == 0) append("Pling")
            if ((n % 5) == 0) append("Plang")
            if ((n % 7) == 0) append("Plong")
            if (isBlank()) append(n)
        }
    }
}