import MeetupSchedule.*
import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {

    fun day(dow: DayOfWeek, msched: MeetupSchedule): LocalDate {
        val daysInMonth = LocalDate.of(year, month, 1).lengthOfMonth()
        val matchingDays = (1..daysInMonth)
                .map { day -> LocalDate.of(year, month, day) }
                .filter { it.dayOfWeek == dow }
        return when (msched) {
            FIRST -> matchingDays[0]
            SECOND -> matchingDays[1]
            THIRD -> matchingDays[2]
            FOURTH -> matchingDays[3]
            LAST -> matchingDays.last()
            TEENTH -> matchingDays.first { it.dayOfMonth in 13..19 }
        }
    }
}