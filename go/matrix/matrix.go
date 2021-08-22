package matrix

import (
	"fmt"
	"strconv"
	"strings"
)

type Matrix [][]int

func New(s string) (Matrix, error) {
	rows := strings.Split(s, "\n")
	m := make([][]int, len(rows))
	for r, line := range rows {
		columns := strings.Split(strings.Trim(line, " "), " ")
		m[r] = make([]int, len(columns))
		for c, column := range columns {
			if value, err := strconv.Atoi(column); err == nil {
				m[r][c] = value
			} else {
				return nil, err
			}
		}

		if r > 0 && len(m[r-1]) != len(m[r]) {
			return nil, fmt.Errorf("inconsistent number of columns")
		}
	}

	return m, nil
}

func (m Matrix) Set(r int, c int, value int) bool {
	if r < 0 || r >= len(m) || c < 0 || c >= len(m[0]) {
		return false
	}
	m[r][c] = value
	return true
}

func (m Matrix) Rows() [][]int {
	m2 := make([][]int, len(m))
	for i, row := range m {
		m2[i] = make([]int, len(row))
		copy(m2[i], row)
	}
	return m2
}

func (m Matrix) Cols() [][]int {
	numRows := len(m)
	numCols := len(m[0])

	m2 := make([][]int, numCols)
	for c := 0; c < numCols; c++ {
		m2[c] = make([]int, numRows)
		for r := 0; r < numRows; r++ {
			m2[c][r] = m[r][c]
		}
	}

	return m2
}
