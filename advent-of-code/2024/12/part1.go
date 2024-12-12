package main

import (
	"os"
	"bufio"
	"fmt"
)

var fname = "in"
var in *bufio.Scanner

var arr [][]rune
var visited [][]bool
var n = 0
var k = 0

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
}


func main() {
	in.Scan()
	var line = in.Text()
	n = len(line)
	arr = make([][]rune, 0, 1000)
	visited = make([][]bool, 0, 1000)
	arr = append(arr, chars(line))
	visited = append(visited, make([]bool, n, n))
	k++
	for in.Scan() {
		line := in.Text()
		arr = append(arr, chars(line))
		visited = append(visited, make([]bool, n, n))
		k++
	}
	var ans int32 = 0
	for i := 0; i < k; i++ {
		for j := 0; j < n; j++ {
			if !visited[i][j] {
				a, p := compt(i, j)
				ans += int32(a*p)
			}
		}
	}
	fmt.Println(ans)
}

func compt(i int, j int) (int, int) {
	visited[i][j] = true
	c := arr[i][j]
	a, p := 1, 0
	for d := 0; d < 4; d++ {
		w, x, y := neigh(i, j, d)
		if !w || arr[x][y] != c {
			p++
		} else if !visited[x][y] {
			b, d := compt(x, y)
			a += b
			p += d
		}
	}
	return a, p
}

func neigh(i int, j int, d int) (bool, int, int) {
	switch d {
	case 0:
		i--
	case 1:
		j++
	case 2:
		i++
	case 3:
		j--
	}
	return within(i, j), i, j
}

func within(i int, j int) bool {
	return i >= 0 && i < k && j >= 0 && j < n
}

func chars(str string) []rune {
	n := len(str)
	ca := make([]rune, n, n)
	for  i, c := range str {
		ca[i] = c
	}
	return ca
}
