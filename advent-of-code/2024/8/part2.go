package main

import (
	"os"
	"fmt"
	"bufio"
)

var fname = "in"
var in  *bufio.Scanner

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
}

func main() {
	in.Scan()
	var line = in.Text()
	var n = len(line)
	var k = 0
	var mm = make(map[rune][]int)
	updateMap(0, mm, line)
	for in.Scan() {
		k++
		line = in.Text()
		updateMap(k*n, mm, line)
	}
	var set = make(map[int]bool)
	k++
	for _, locations := range mm {
		for i := 0; i < len(locations); i++ {
			for j := i + 1; j < len(locations); j++ {
				antinodes(locations[i], locations[j], n, k, set)
			}
		}
	}
	fmt.Println(len(set))
}

func updateMap(k int, mm map[rune][]int, line string) {
	for i, c := range line {
		if c != '.' {
			arr, exist := mm[c]
			if !exist {
				mm[c] = make([]int, 0, 1000)
			}
			mm[c] = append(arr, k + i)
		}
	}	
}

func antinodes(a int, b int, n int, k int, set map[int]bool) {
	x1, y1 := a%n, a/n
	x2, y2 := b%n, b/n
	dx := x2 - x1
	dy := y2 - y1
	for i := 0;; i++ {
		x := x1 - i*dx
		y := y1 - i*dy
		if within_map(x, y, n, k) {
			set[y*n + x] = true
		} else {
			break
		}
	}
	for i := 0;; i++ {
		x := x2 + i*dx
		y := y2 + i*dy
		if within_map(x, y, n, k) {
			set[y*n + x] = true
		} else {
			break
		}
	}
}

func within_map(x int, y int, n int, k int) bool {
	return x >= 0 && x < n && y >= 0 && y < k
}
