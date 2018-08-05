import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond {

    val date: LocalDateTime

    constructor(birth: LocalDate) {
        date = birth.atTime(0, 0).plusSeconds(1_000_000_000)
    }

    constructor(birth: LocalDateTime) {
        date = birth.plusSeconds(1_000_000_000)
    }
}