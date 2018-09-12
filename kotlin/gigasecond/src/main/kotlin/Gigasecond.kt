import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(birth: LocalDateTime) {

    val date = birth.plusSeconds(1_000_000_000)

    constructor(birth: LocalDate) : this(birth.atStartOfDay())
}