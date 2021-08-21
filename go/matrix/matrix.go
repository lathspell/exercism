package matrix

import (
	"fmt"
	"regexp"
	"strings"
)

type Matrix [][]int

func New(s string) (Matrix, error) {
	if matched, err := regexp.Match(`^[\d\n ]+$`, []byte(s)); !matched || err != nil {
		return nil, fmt.Errorf("illegal characters")
	}

	m := new(Matrix)
	mp := *m

	lines := strings.Split(s, "\n")
	colSplitter := regexp.MustCompile(`\d+`)
	expectedCols := -1
	for y := 0; y < len(lines); y++ {
		line := lines[y]
		tokenSubstrings := colSplitter.FindAll([]byte(line), -1)

		// Check for correct number of columns
		actualCols := len(tokenSubstrings)
		if expectedCols == -1 {
			expectedCols = actualCols
		} else if expectedCols != actualCols {
			return nil, fmt.Errorf("unexpected number of columns %d instead of %d", actualCols, expectedCols)
		}

		mp = append(mp, []int{})
		for x := 0; x < len(tokenSubstrings); x++ {
			tokenSubstring := string(tokenSubstrings[x])
			var value int
			_, err := fmt.Sscanf(tokenSubstring, "%d", &value)
			if err != nil {
				return nil, err
			}
			mp[y] = append(mp[y], value)
		}
	}

	return mp, nil
}

func (m *Matrix) Set(r int, c int, value int) bool {
	mp := *m
	numRows, numCols := m.dimensions()
	if r < 0 || r >= numRows || c < 0 || c >= numCols {
		return false
	}

	mp[r][c] = value
	return true
}

func (m *Matrix) Rows() [][]int {
	mp := *m
	numRows, numCols := m.dimensions()

	m2 := make([][]int, numRows)
	for i := 0; i < numRows; i++ {
		m2[i] = make([]int, numCols)
		copy(m2[i], mp[i])
	}
	return m2
}

func (m *Matrix) Cols() [][]int {
	mp := *m
	numRows, numCols := m.dimensions()

	m2 := make([][]int, numCols)
	for c := 0; c < numCols; c++ {
		m2[c] = make([]int, numRows)
		for r := 0; r < numRows; r++ {
			m2[c][r] = mp[r][c]
		}
	}

	return m2
}

func (m *Matrix) dimensions() (int, int) {
	mp := *m
	numRows := len(mp)
	numCols := 0
	if numRows > 0 {
		numCols = len(mp[0])
	}
	return numRows, numCols
}
