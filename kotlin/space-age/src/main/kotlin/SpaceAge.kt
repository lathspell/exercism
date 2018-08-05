class SpaceAge(private val age: Long) {

    private val earthSeconds = 31557600

    private fun calc(x: Double) = Math.round(age / x / earthSeconds * 100) / 100.0

    fun onEarth() = calc(1.0)
    fun onMercury() = calc(0.2408467)
    fun onVenus() = calc(0.61519726)
    fun onMars() = calc(1.8808158)
    fun onJupiter() = calc(11.862615)
    fun onSaturn() = calc(29.447498)
    fun onUranus() = calc(84.016846)
    fun onNeptune() = calc(164.79132)
}