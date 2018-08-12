import java.util.*

// changed: learned unsigned modulo trick from ErikSchierboom's solution
class Cipher(val key: String) {

    constructor() :
            this(Random().ints(100, 0, 25).toArray().map { 'a' + it }.joinToString(""))

    init {
        require(key.all { it in 'a'..'z' })
        require(key.isNotEmpty())
    }

    fun encode(s: String): String = translate(s, true)
    fun decode(s: String): String = translate(s, false)

    private fun translate(s: String, encode: Boolean) =
            s.mapIndexed { i, c ->
                val keyi = key[i % key.length] - 'a'
                val ci = c - 'a'
                val newi = if (encode) (ci + keyi) else (ci - keyi)
                val newiMod = (newi + 26) % 26 // mod() returns negative values for negative input!
                'a' + newiMod
            }.joinToString("")

}