package bob

import (
	. "regexp"
	. "strings"
)

func Hey(remark string) string {
	it := TrimSpace(remark)
	hasUc, _ := MatchString("[A-Z]", it)
	hasLc, _ := MatchString("[a-z]", it)
	question := HasSuffix(it, "?")
	empty := it == ""
	yelled := hasUc && !hasLc

	switch {
	case empty:
		return "Fine. Be that way!"
	case yelled && question:
		return "Calm down, I know what I'm doing!"
	case yelled:
		return "Whoa, chill out!"
	case question:
		return "Sure."
	default:
		return "Whatever."
	}
}
