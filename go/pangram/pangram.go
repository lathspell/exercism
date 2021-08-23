package pangram

import "strings"

func IsPangram(s string) bool {
	lc := strings.ToLower(s)
	for r := 'a'; r <= 'z'; r++ {
		if !strings.ContainsRune(lc, r) {
			return false
		}
	}
	return true
}
