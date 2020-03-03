package luhn

import (
	"fmt"
	"regexp"
	"strings"
)

func Valid(input string) bool {
	cleaned := strings.ReplaceAll(input, " ", "")

	// Check for empty strings
	if cleaned == "" {
		return false
	}
	// Check for any non digits
	if regexp.MustCompile("[^0-9]").MatchString(cleaned) {
		return false
	}

	// Reverse iteration
	acc := 0
	for i := len(cleaned) - 1; i > 0; i-- {
		x := int(cleaned[i]) - '0'
		fmt.Printf(" i=%d x=%d\n", i, x)
		switch {
		case (i % 2) == 0:
			acc += x
		case x < 5:
			acc += 2 * x
		default:
			acc += 2*x - 9
		}
	}
fmt.Printf("cleaned=%s acc=%d\n", cleaned, acc)
	return (acc % 10) == 0
}

/*
fun isValid(s: String) = s
                .filterNot { it.isWhitespace() }
                .apply {
                    if (length <= 1) return false
                    if (any { !it.isDigit() }) return false
                }
                .map { Character.getNumericValue(it) }
                .reversed()
                .foldIndexed(0) { index, acc, x ->
                    acc + when {
                        index % 2 == 0 -> x
                        x < 5 -> x * 2
                        else -> x * 2 - 9
                    }
                } % 10 == 0
*/
