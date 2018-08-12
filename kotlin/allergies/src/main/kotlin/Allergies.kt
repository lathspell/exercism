class Allergies(private val n: Int) {

    fun getList(): List<Allergen> = Allergen.values().filter { isAllergicTo(it) }

    fun isAllergicTo(x: Allergen): Boolean = n and x.score == x.score

}