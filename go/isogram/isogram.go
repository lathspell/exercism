package isogram

import (
	"strings"
)

func IsIsogram(input string) bool {
	lcInput := strings.ToLower(input)

	chars := make(map[rune]bool)
	for _, r := range lcInput {
		if r == '-' || r == ' ' {
			continue
		}
		if chars[r] {
			return false
		}
		chars[r] = true
	}
	return true
}

/*
     fun isIsogram(s: String): Boolean {
           val set = mutableSetOf<Char>()
           return s.toLowerCase().filter { it != ' ' && it != '-' }.all { set.add(it) }
       }
   }
*/
