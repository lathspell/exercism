package robotname

import (
	"fmt"
	"math/rand"
)

type Robot struct {
	name string
}

func (r *Robot) Name() (string, error) {
	if r.name == "" {
		newname, err := generateUniqueName()
		if err != nil {
			return "", err
		}
		r.name = newname
	}
	return r.name, nil
}

func (r *Robot) Reset() error {
	newname, err := generateUniqueName()
	if err != nil {
		return err
	}
	r.name = newname
	return nil
}

var names = make(map[string]bool)
var numPossibleNames int = 26 * 26 * 10 * 10 * 10

func generateUniqueName() (string, error) {
	if len(names) > numPossibleNames {
		return "", fmt.Errorf("namespace exhausted")
	}

	var name string
	for found := true; found; _, found = names[name] {
		name = randomRobotName()
	}
	names[name] = true

	return name, nil
}

func randomRobotName() string {
	return fmt.Sprintf("%c%c%03d", randomUpperChar(), randomUpperChar(), rand.Intn(1000))
}

func randomUpperChar() int {
	return 'A' + rand.Intn('Z'-'A')
}
