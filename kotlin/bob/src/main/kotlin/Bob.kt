class Bob {
    companion object {
        fun hey(s: String) = s.trim().let {
            when {
                it.isEmpty() -> "Fine. Be that way!"
                it.contains(Regex("[A-Z]")) && !it.contains(Regex("[a-z]")) -> "Whoa, chill out!"
                it.endsWith("?") -> "Sure."
                else -> "Whatever."
            }
        }
    }
}
