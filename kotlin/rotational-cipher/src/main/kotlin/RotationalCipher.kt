class RotationalCipher(private val rot: Int) {
    fun encode(plain: String) : String = plain.map {
        when (it) {
            in 'a'..'z' -> 'a' + (it - 'a' + rot) % 26
            in 'A'..'Z' -> 'A' + (it - 'A' + rot) % 26
            else -> it
        }
    }.joinToString("")
}
