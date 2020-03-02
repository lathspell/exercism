package hamming

import (
	"errors"
)

// Distance of two strings measured in count of non matching chars
func Distance(a, b string) (out int, err error) {
	if len(a) != len(b) {
		return 0, errors.New("left and right strands must be of equal length")
	}
	for i := range a {
		if a[i] != b[i] {
			out++
		}
	}
	return out, nil
}

/*
fun compute(a: String, b: String): Int {
	require(a.length == b.length) { "left and right strands must be of equal length." }
	return a.indices.count { a[it] != b[it] }
}
*/
