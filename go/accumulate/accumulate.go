package accumulate

func Accumulate(collection []string, lambda func(string) string) []string {
	result := make([]string, len(collection))
	for i, element := range collection {
		result[i] = lambda(element)
	}
	return result
}
