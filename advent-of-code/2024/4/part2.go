package main

import (
	"bufio"
	"fmt"
	"os"
)

const fname = "in"
var in *bufio.Scanner

var str = "MAS"

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
}

func main() {
	var lines = make([]string, 0, 200)
	for in.Scan() {
		var line = in.Text()
		lines = append(lines, line)
	}
	var n = len(lines[0])
	var m = len(lines)
	var ans int = 0
	for i := 0; i < n - 2; i++ {
		for j := 0; j < m - 2; j++ {
			ans += compute(lines, i, j)
		}
	}
	fmt.Println(ans)
}

func compute(lines []string, x int, y int) int {
	if (isMas(lines, x, y, 1, 1) || isMas(lines, x + 2, y + 2, -1, -1)) &&
	(isMas(lines, x + 2, y, -1, 1) || isMas(lines, x, y + 2, 1, -1)) {
		return 1
	}
	return 0
}

func isMas(a []string, x int, y int, dx int, dy int) bool {
	for i := 0; i < len(str); i++ {
		if a[x + i*dx][y + i*dy] != str[i] {
			return false
		}
	}
	return true
	
}

