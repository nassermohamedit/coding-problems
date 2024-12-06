package main

import (
	"bufio"
	"os"
	"fmt"
)

var fname = "in"
var in *bufio.Scanner

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
}


func main() {
	var arr = make([][]int, 0, 200)
	for in.Scan() {
		var line = in.Text()
		var a = make([]int, 0, 200)
		for c := range line {
			a = append(a, int(line[c]))
		}
		arr = append(arr, a)
	}
	var n = len(arr)
	var m = len(arr[0])
	var x0 = -1
	var y0 = -1
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if arr[i][j] == int('^') {
				x0 = i
				y0 = j
				goto cont
			}
		}
	}
	cont:
	var ans = 0
	for i := 0; i < n; i++ { 
		for j := 0; j < m; j++ {
			if arr[i][j] == int('.') {
				arr[i][j] = int('#')
				ans += isLooping(x0, y0, n, m, arr)
				arr[i][j] = int('.')
				restore(x0, y0, n, m, arr)
			}
		}
	}
	fmt.Println(ans)
}

func move(x int, y int, d int) (int, int) {
	switch (d) { 
	case 0: return x - 1, y
	case 1: return x, y + 1
	case 2: return x + 1, y
	case 3: return x, y - 1
	}
	return -1, -1
}

func turn(d int) int {
	return (d + 1) % 4
}

func isLooping(x int, y int, n int, m int, arr [][]int) int {
	d := 0
	arr[x][y] = d
	for {
		xp, yp := move(x, y, d)
		if xp < 0 || xp >= n || yp < 0 || yp >= m {
			return 0
		}
		if arr[xp][yp] == int('#') {
			d = turn(d)
		} else {
			x = xp
			y = yp
			if arr[x][y] == d {
				return 1
			}
			arr[x][y] = d
		}
	}
}

func restore(x0 int, y0 int, n int, m int, arr [][]int) {
	for i := 0; i < n; i++ { 
		for j := 0; j < m; j++ {
			if arr[i][j] != int('#') {
				arr[i][j] = int('.')
			}
		}
		arr[x0][y0] = int('^')
	}
}	
