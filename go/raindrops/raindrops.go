package raindrops

import "fmt"

// Convert raindrops to funny string
func Convert(n int) (out string) {
	if (n % 3) == 0 {
		out += "Pling"
	}
	if (n % 5) == 0 {
		out += "Plang"
	}
	if (n % 7) == 0 {
		out += "Plong"
	}
	if out == "" {
		out += fmt.Sprintf("%d", n)
	}
	return
}

/*
	fun convert(n: Int) = buildString {
		if ((n % 3) == 0) append("Pling")
		if ((n % 5) == 0) append("Plang")
		if ((n % 7) == 0) append("Plong")
		if (isBlank()) append(n)
	}
*/
