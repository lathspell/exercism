import Relationship.*

fun <E> List<E>.relationshipTo(other: List<E>): Relationship =
        when {
            this == other -> EQUAL
            this.isEmpty() -> SUBLIST
            other.windowed(this.size).any { it == this } -> SUBLIST
            other.isEmpty() -> SUPERLIST
            this.windowed(other.size).any { it == other } -> SUPERLIST
            else -> UNEQUAL
        }

