package flatten

import (
	"reflect"
)

func Flatten(input interface{}) []interface{} {
	inputSlice := input.([]interface{}) // "type assertion"

	result := []interface{}{}
	for _, v := range inputSlice {

		typeof := reflect.TypeOf(v)
		if typeof == nil {
			continue
		}

		switch typeof.Kind() {
		case reflect.Slice:
			result = append(result, Flatten(v)...) // recursion for sublists
		default:
			result = append(result, v.(int))
		}
	}

	return result
}
