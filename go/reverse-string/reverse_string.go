package reverse

func Reverse(input string) (out string) {
	runes := []rune(input) // every character is now represented by exactly two bytes
	for i := len(runes) - 1; i >= 0; i-- {
		out += string(runes[i])
	}
	return
}

/*
fun reverse(s: String) = s.reversed()
*/
