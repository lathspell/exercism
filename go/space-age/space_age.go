package space

// Planet name
type Planet string

var secsPerYearsOnEarth = 31557600.0

var secsPerYear = map[Planet]float64{
	"Earth":   secsPerYearsOnEarth,
	"Mercury": secsPerYearsOnEarth * 0.2408467,
	"Venus":   secsPerYearsOnEarth * 0.61519726,
	"Mars":    secsPerYearsOnEarth * 1.8808158,
	"Jupiter": secsPerYearsOnEarth * 11.862615,
	"Saturn":  secsPerYearsOnEarth * 29.447498,
	"Uranus":  secsPerYearsOnEarth * 84.016846,
	"Neptune": secsPerYearsOnEarth * 164.79132,
}

// Age on the given planet
func Age(seconds float64, planet Planet) float64 {
	return seconds / secsPerYear[planet]
}
