package main


import (
	"fmt"
	"bufio"
	"os"
	"unicode"
)

const (
	Start = iota
	M
	U
	L
	Opar
	D11
	D12
	D13
	Comma
	D21
	D22
	D23
)

var reader *bufio.Reader 

func init() {
	in, _ := os.Open("in")
	reader = bufio.NewReader(in)
}

var a, b int
var sum int64
var state = Start

func updateA(r rune) {
	a = a*10 + int(r - '0')
}

func updateB(r rune) {
	b = b*10 + int(r - '0')
}


func isDigit(r rune) bool {
	return unicode.IsDigit(r)
}

func handleResult() {
	sum += int64(a * b)
}

func resetState() {
	state = Start
	a = 0
	b = 0
}

func get() (rune, bool) {
	r, _, err := reader.ReadRune()
	if err != nil {
		return '0', true
	}
	return r, false
}

func transition(r rune) {
	var reset = true
	switch state {
	case Start:
		if r == 'm' {
			state = M
		}
		reset = false
	case M:
		if r == 'u' {
			state = U
			reset = false
		}
	case U:
		if r == 'l' {
			state = L
			reset = false
		}
	case L:
		if r == '(' {
			state = Opar
			reset = false
		}
	case Opar:
		if isDigit(r) {
			updateA(r)
			state = D11
			reset = false
		}
	case D11:
		if isDigit(r) {
			updateA(r)
			state = D12
			reset = false
		} else if r == ',' {
			state = Comma
			reset = false
		}
	case D12:
		if isDigit(r) {
			updateA(r)
			state = D13
			reset = false
		} else if r == ',' {
			state = Comma
			reset = false
		}
	case D13:
		if r == ',' {
			state = Comma
			reset = false
		}
	case Comma:
		if isDigit(r) {
			updateB(r)
			state = D21
			reset = false
		}
	case D21:
		if isDigit(r) {
			updateB(r)
			state = D22
			reset = false
		} else if r == ')' {
			handleResult()
		}
	case D22:
		if isDigit(r) {
			updateB(r)
			state = D23
			reset = false
		} else if r == ')' {
			handleResult()
		}
	case D23:
		if r == ')' {
			handleResult()
		}
	}
	if reset {
		resetState()
		transition(r)
	}
}

func process() {
	r, eoi := get()
	for !eoi {
		transition(r)
		r, eoi = get()		
	}
}

func main() {
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	process()
	fmt.Fprintln(writer, sum)
}
