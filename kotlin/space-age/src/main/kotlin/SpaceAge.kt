import kotlin.math.round

class SpaceAge(private val earthSecs: Long) {
    fun onEarth(): Double = calcTo2(1.0)
    fun onMercury(): Double = calcTo2(0.2408467)
    fun onVenus(): Double = calcTo2(0.61519726)
    fun onMars(): Double = calcTo2(1.8808158)
    fun onJupiter(): Double = calcTo2(11.862615)
    fun onSaturn(): Double = calcTo2(29.447498)
    fun onUranus(): Double = calcTo2(84.016846)
    fun onNeptune(): Double = calcTo2(164.79132)

    private val earthSecsPerYear = 31557600.0
    private fun calcTo2(x: Double) = roundTo2(earthSecs / earthSecsPerYear / x)
    private fun roundTo2(d: Double) = round(d * 100) / 100.0
}
