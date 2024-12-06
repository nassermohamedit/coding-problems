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
	var arr = make([][]rune, 0, 200)
	for in.Scan() {
		var line = in.Text()
		var a = make([]rune, 0, 200)
		for c := range line {
			a = append(a, rune(line[c]))
		}
		arr = append(arr, a)
	}
	var n = len(arr)
	var m = len(arr[0])
	var x, y int
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if arr[i][j] == '^' {
				x = i
				y = j
				goto cont
			}
		}
	}
	cont:
	var d = []int {-1, 0}
	var ans = 1
	arr[x][y] = '0'
	for {
		xp, yp := move(x, y, d)
		if xp < 0 || xp >= n || yp < 0 || yp >= m {
			break
		}
		if arr[xp][yp] == '#' {
			turn(d)
		} else {
			x = xp
			y = yp
			if arr[x][y] != '0' {
				ans++
				arr[x][y] = '0'
			}
		}
	}
	fmt.Println(ans)
}

func move(x int, y int, d []int) (int, int) {
	return x + d[0], y + d[1]
}

func turn(d []int) {
	temp := d[0]
	d[0] = d[1]
	d[1] = -temp
}
