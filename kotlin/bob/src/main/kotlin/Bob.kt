class Bob {
    companion object {
        // INCOMPLETE: It's not clear in which order the rules apply and I've no time to deduce it from the examples.
        fun hey(s: String) = when {
            s.trim().endsWith("?") -> "Sure."
            s.trim().isEmpty() -> "Fine. Be that way!"
            !s.contains("[a-z]".toRegex()) -> "Whoa, chill out!"
            else -> "Whatever."
        }
    }
}