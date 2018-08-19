// changed: After reading bugfry's solution I gave this one another try using only Regex
// It's not as short but I went for readability for this one.
object PigLatin {

    fun translate(phrase: String): String = phrase.split(" ").map {
        when {
            // 1. Ay is added to words that start with vowels
            Regex("[aeiou].*").matches(it) -> it + "ay"
            // 10. Yt is treated like a single vowel
            // 11. Xr is treated like a single vowel
            Regex("(yt|xr).*").matches(it) -> it + "ay"
            // 2. Ay is added to words that start with vowels followed by qu
            Regex("[aeiou]qu.*").matches(it) -> it + "ay"
            // 6. Qu and a single preceding consonant are treated like a single consonant
            Regex("[^aeiou]qu.*").matches(it) -> it.drop(3) + it.substring(0, 3) + "ay"
            // 8. Thr is treated like a single consonant
            // 9. Sch is treated like a single consonant
            Regex("(thr|sch).*").matches(it) -> it.drop(3) + it.substring(0, 3) + "ay"
            // 4. Ch is treated like a single consonant
            // 5. Qu is treated like a single consonant
            // 7. Th is treated like a single consonant
            Regex("(ch|qu|th).*").matches(it) -> it.drop(2) + it.substring(0, 2) + "ay"
            // 13. Y is treated like a vowel at the end of a consonant cluster
            // 14. Y as second letter in two letter word
            Regex("[^aeiou]+y.*").matches(it) -> it.drop(it.indexOf('y')) + it.substring(0, it.indexOf('y')) + "ay"
            // 3. First letter and ay are moved to the end of words that start with consonants
            // 12. Y is treated like a consonant at the beginning of a word
            Regex("([^aeiou]).*").matches(it) -> it.drop(1) + it[0] + "ay"
            else -> it
        }
    }.joinToString(" ")
}
