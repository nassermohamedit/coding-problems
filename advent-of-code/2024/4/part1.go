package main

import (
	"bufio"
	"fmt"
	"os"
)

const fname = "in"
var in *bufio.Scanner

var str = "XMAS"

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
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			ans += compute(lines, i, j, n, m)
		}
	}
	fmt.Println(ans)
}

func compute(lines []string, x int, y int, n int, m int) int {
	var cnt int = 0
	if y + 3 < n {
		cnt += comptXmas(lines, x, y, 0, 1, n, m)
		cnt += comptXmas(lines, x, y + 3, 0, -1, n, m)
	}
	if x + 3 < m {
		cnt += comptXmas(lines, x, y, 1, 0, n, m)
		cnt += comptXmas(lines, x + 3, y, -1, 0, n, m)
	}
	if x + 3 < m && y + 3 < n {
		cnt += comptXmas(lines, x, y, 1, 1, n, m)
		cnt += comptXmas(lines, x + 3, y + 3, -1, -1, n, m)
		cnt += comptXmas(lines, x, y + 3, 1, -1, n, m)
		cnt += comptXmas(lines, x + 3, y, -1, 1, n, m)
	}
	return cnt
}

func comptXmas(a []string, x int, y int, dx int, dy int, n int, m int) int {
	for i := 0; i < 4; i++ {
		if a[x + i*dx][y + i*dy] != str[i] {
			return 0
		}
	}
	return 1
	
}

