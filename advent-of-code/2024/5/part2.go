package main

import (
	"bufio"
	"os"
	"fmt"
	"strconv"
	"strings"
)

var file = "in"
var in *bufio.Scanner

func init() {
	inf, _ := os.Open(file)
	in = bufio.NewScanner(inf)
}

func main() {
	var order = make([][]int, 100, 100)
	for i := 0; i < 100; i++ {
		order[i] = make([]int, 100, 100)
	}
	var arr = make([]int, 100, 100)
	for in.Scan() {
		var line = in.Text()
		if line == "" {
			break
		}
		var u, v int
		var vals = strings.Split(line, "|")
		u, _ = strconv.Atoi(vals[0])
		v, _ = strconv.Atoi(vals[1])
		order[u][v] = 1
		order[v][u] = -1
	}
	var ans = 0
	for in.Scan() {
		var line = strings.Split(in.Text(), ",")
		var n = len(line)
		for i := 0; i < n; i++ {
			arr[i], _ = strconv.Atoi(line[i])
		}
		var ordered = true

		// We don't know if the given rules cover all possible pairs
		// And there is no cnstraint on the range of the numbers to begin with
		// so we can't assume that order[x][y] == 0 means that x and y are equal
		// order[x][y] == 0 when there is no rule given for (x, y) or x == y
		// We would pre-compute order[x][y] for all (x, y) but still we don't know
		// the range in which the values vary.
		// So deciding if the array is ordered in one linear pass is not possible
		// Given x y0 y1 .. yk z.
		// it could be the case that x <= y0, y0 <= y1 .. yk <= z but z < x
		// One linear pass (compairing consecutive pairs) will not detect this violation
		// We can either compute the rule for a pair of consecurive elements if not given
		// as we iterate, or we can do a simple nested loop as follow
		for i := 0; i < n; i++ {
			for j := i + 1; j < n; j++ {
				if order[arr[i]][arr[j]] == -1 {
					ordered = false
					break
				}
			}
		}
		if !ordered {
			// sort the array using a comparator that uses the information in order matrix
			// to compare elements x <= y iff order[x][y] != -1
			quick_sort(arr, 0, n - 1, order)
			ans += arr[n/2]
		}
	}
	fmt.Println(ans)
}

func quick_sort(a []int, l int, r int, order [][]int) {
	if l > r {
		return
	}
	var x = a[r]
	var i = l - 1
	for j := l; j < r; j++ {
		if order[a[j]][x] != -1 {
			i++
			temp := a[i]
			a[i] = a[j]
			a[j] = temp
		}
	}
	a[r] = a[i + 1]
	a[i + 1] = x
	quick_sort(a, l, i, order)
	quick_sort(a, i + 2, r, order)
}
