package scrabble

import (
	"strings"
)

var scores = map[string]int{
	"AEIOULNRST": 1,
	"DG":         2,
	"BCMP":       3,
	"FHVWY":      4,
	"K":          5,
	"JX":         8,
	"QZ":         10,
}

// Score input string according to Scrabble rules
func Score(s string) (out int) {
	uc := strings.ToUpper(s)
	for _, r := range uc {
		for letters, points := range scores {
			if strings.Contains(letters, string(r)) {
				out += points
				break
			}
		}
	}
	return
}

/*
fun scoreWord(s: String) = s.toUpperCase().sumBy {
	when (it) {
		in "AEIOULNRST" -> 1
		in "DG" -> 2
		in "BCMP" -> 3
		in "FHVWY" -> 4
		in "K" -> 5
		in "JX" -> 8
		in "QZ" -> 10
		else -> 0
	}
}
*/
