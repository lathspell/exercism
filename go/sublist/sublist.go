package sublist

type Relation string

func Sublist(a []int, b []int) Relation {
	switch {
	case isEqual(a, b):
		return "equal"
	case isSublist(a, b):
		return "sublist"
	case isSublist(b, a):
		return "superlist"
	default:
		return "unequal"
	}
}

func isSublist(a []int, b []int) bool {
	for bOffset := 0; bOffset < len(b)-len(a)+1; bOffset++ {
		if isEqual(a, b[bOffset:bOffset+len(a)]) {
			return true
		}
	}
	return false
}

func isEqual(a []int, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i, v := range a {
		if v != b[i] {
			return false
		}
	}
	return true
}
