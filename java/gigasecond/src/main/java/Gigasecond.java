import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime date;

    Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    Gigasecond(LocalDateTime birthDateTime) {
        date = birthDateTime.plus(Duration.ofSeconds(1_000_000_000));
    }

    LocalDateTime getDate() {
        return date;
    }

}
