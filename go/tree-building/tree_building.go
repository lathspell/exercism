// Package tree builds a tree structure from records
package tree

import (
	"errors"
	"fmt"
	"sort"
)

// Record represents a single record like a message
type Record struct {
	ID     int
	Parent int
}

// Node is the component that forms the tree with Id referencing Records
type Node struct {
	ID       int
	Children []*Node
}

// Build creates a tree from a given set of Records
func Build(records []Record) (*Node, error) {
	fmt.Printf("\n=== Build(%v) ===\n", records)

	// Sort records so that we always have the trunk before its leaves
	sort.SliceStable(records, func(i, j int) bool {
		return records[i].ID < records[j].ID
	})

	if len(records) > 0 && records[0].ID != records[0].Parent {
		return nil, errors.New("expect first root to have ID == Parent")
	}

	var root *Node
	var error error
	var lastID = -1
	for _, r := range records {

		if r.ID != lastID + 1 {
			return nil, errors.New("duplicate or non continuous record")
		}
		lastID++

		root, error = insert(root, &r)
		if error != nil {
			return nil, error
		}
	}

	return root, nil
}

func insert(root *Node, record *Record) (*Node, error) {
	// check root
	if root == nil {
		root = &Node{ID: record.ID}
		return root, nil
	}

	// find parent
	var parent = findNode(root, record.Parent)
	if parent == nil {
		return nil, errors.New("no parent")
	}

	// append record to just found parent
	parent.Children = append(parent.Children, &Node{ID: record.ID})

	// always return root, not parent
	return root, nil
}

func findNode(node *Node, wanted int) *Node {
	if node.ID == wanted {
		return node
	}

	for _, child := range node.Children {
		var found = findNode(child, wanted)
		if found != nil {
			return found
		}
	}

	return nil
}
