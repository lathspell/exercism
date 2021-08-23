package etl

import "strings"

func Transform(input map[int][]string) map[string]int {
	output := make(map[string]int)
	for points, chars := range input {
		for _, c := range chars {
			output[strings.ToLower(c)] = points
		}
	}
	return output
}
