package atbash

import (
	"strings"
)

func Atbash(s string) string {
	sb := []rune{}
	written := 0
	for _, r := range s {
		translated := translateChar(r)
		if translated > 0 {
			sb = append(sb, translated)
			
			written++
			if (written % 5) == 0 {
				sb = append(sb, ' ')
			}
		}
	}
	return strings.TrimRight(string(sb), " ")
}

func translateChar(r rune) rune {
	switch {
	case r >= 'a' && r <= 'z':
		return ('z' - (r - 'a'))
	case r >= 'A' && r <= 'Z':
		return ('z' - (r - 'A'))
	case r >= '0' && r <= '9':
		return r
	default:
		return -1
	}
}
