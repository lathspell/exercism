import java.util.regex.Pattern
import java.util.regex.Pattern.COMMENTS

// changed: written in functional style using "let" without assignments
// changed: use "takeIf" and "?." instead of "else return null"
// changed: use COMMENTS to make RegEx more readable
class PhoneNumber(private val writtenNumber: String) {

    val number: String? = sanitizeNumber(writtenNumber)

    private fun sanitizeNumber(s: String): String? = s
            .replace("""\D""".toRegex(), "")
            .let { Pattern.compile("""1?( [2-9]\d\d [2-9]\d\d \d{4} )""", COMMENTS).matcher(it) }
            .takeIf { it.matches() }
            ?.group(1)

}

