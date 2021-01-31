// Package tree builds a tree structure from records
package tree

// Record represents a single record like a message
type Record struct {
	ID int
	Parent int
}

// Node is the component that forms the tree with Id referencing Records
type Node struct {
	ID int
	Children []*Node
}

// Build creates a tree from a given set of Records
func Build(records []Record) (*Node, error) {
	var first *Node
	for _,r := range records {
		first = insert(&r, first)
	}
	return first, nil
}

func insert(record *Record, first *Node) *Node {
	if (first == nil) {
		first = &Node{ ID : record.ID }
	}

	if first.ID == record.Parent {
		first = append(first.Children, record)
	}

	return first
}