package letter

// FreqMap records the frequency of each rune in a given text.
type FreqMap map[rune]int

// Frequency counts the frequency of each rune in a given text and returns this
// data as a FreqMap.
func Frequency(s string) FreqMap {
	m := FreqMap{}
	for _, r := range s {
		m[r]++
	}
	return m
}

// ConcurrentFrequency returns the frequency of each rune in a given text as FreqMap (but faster)
func ConcurrentFrequency(lines []string) FreqMap {
	ch := make(chan FreqMap, len(lines))

	for _, s := range lines {
		go func(s string) {
			ch <- Frequency(s)
		}(s)
	}

	totals := FreqMap{}
	for range lines {
		for rune, freq := range <-ch {
			totals[rune] += freq
		}
	}
	return totals
}
