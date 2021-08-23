package protein

import (
	"errors"
)

var ErrStop = errors.New("stop")
var ErrInvalidBase = errors.New("invalid base")

var cordon2protein = map[string]string{
	"AUG": "Methionine",
	"UUU": "Phenylalanine",
	"UUC": "Phenylalanine",
	"UUA": "Leucine",
	"UUG": "Leucine",
	"UCU": "Serine",
	"UCC": "Serine",
	"UCA": "Serine",
	"UCG": "Serine",
	"UAU": "Tyrosine",
	"UAC": "Tyrosine",
	"UGU": "Cysteine",
	"UGC": "Cysteine",
	"UGG": "Tryptophan",
	"UAA": "STOP",
	"UAG": "STOP",
	"UGA": "STOP",
}

func FromCodon(input string) (string, error) {
	proteine := cordon2protein[input]
	switch proteine {
	case "":
		return "", ErrInvalidBase
	case "STOP":
		return "", ErrStop
	default:
		return proteine, nil
	}
}

func FromRNA(rna string) ([]string, error) {
	proteins := []string{}
	for i := 0; i <= len(rna)-3; i += 3 {
		protein, err := FromCodon(rna[i : i+3])
		switch err {
		case ErrInvalidBase:
			return proteins, ErrInvalidBase
		case ErrStop:
			return proteins, nil
		default:
			proteins = append(proteins, protein)
		}
	}
	return proteins,nil
}
