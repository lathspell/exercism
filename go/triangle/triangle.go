package triangle

import (
	"math"
)

type Kind string

// could have used "Nat Kind = iota" but strings are more readable when debugging
const (
	NaT = "not a triangle"
	Equ = "equilateral"
	Iso = "isosceles"
	Sca = "scalene"
)

func KindFromSides(a, b, c float64) Kind {
	// all sides must have a positive and finite length
	if math.IsNaN(a) || a <= 0 || math.IsInf(a, 1) ||
		math.IsNaN(b) || b <= 0 || math.IsInf(b, 1) ||
		math.IsNaN(c) || c <= 0 || math.IsInf(c, 1) {
		return NaT
	}

	// every two sides must in sum be greater than the remaining one
	if a+b < c || b+c < a || c+a < b {
		return NaT
	}

	switch {
	case a == b && b == c:
		return Equ
	case a == b || b == c || a == c:
		return Iso
	default:
		return Sca
	}
}
