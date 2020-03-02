package acronym

import (
	"regexp"
	"strings"
)

// Abbreviate creates an acronym from the input string
func Abbreviate(s string) (out string) {
	cleaned := regexp.MustCompile("[-_, ]").ReplaceAllLiteralString(s, " ")
	parts := strings.Fields(cleaned)
	for _, part := range parts {
		out += string(part[0])
	}

	return strings.ToUpper(out)
}
