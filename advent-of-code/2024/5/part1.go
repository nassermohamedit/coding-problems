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
		for i := 0; i < n; i++ {
			for j := i + 1; j < n; j++ {
				if order[arr[i]][arr[j]] == -1 {
					ordered = false
					break
				}
			}
		}
		if ordered {
			ans += arr[n/2]
		}
	}
	fmt.Println(ans)
}
