package main

import(
	"os"
	"bufio"
	"fmt"
)

var fname = "in"
var in *bufio.Scanner

var grid [][]int
var cnt [][]int
var n = -1
var k = 0

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
	grid = make([][]int, 0, 100)
	cnt = make([][]int, 0, 100)
}



func main() {
	for in.Scan() {
		line := in.Text()
		n = len(line)
		grid_row := make([]int, n, n)
		cnt_row := make([]int, n, n)
		for i, d := range line {
			grid_row[i] = int(d - '0')
			cnt_row[i] = -1
		}
		grid = append(grid, grid_row)
		cnt = append(cnt, cnt_row)
		k++
	}
	ans := 0
	for i := 0; i < k; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 0 {
				ans += count_paths(j, i)
			}
		}
	}
	fmt.Println(ans)
}


func count_paths(x int, y int) int {
	if x < 0 || x >= n || y < 0 || y >= k {
		return 0
	}
	if cnt[y][x] != -1 {
		return cnt[y][x]
	}
	if grid[y][x] == 9 {
		cnt[y][x] = 1
		return 1
	}
	result := 0
	next_height := grid[y][x] + 1
	left := x - 1
	if left >= 0 && grid[y][left] == next_height {
		result += count_paths(left, y)
	}
	up := y - 1
	if up >= 0 && grid[up][x] == next_height {
		result += count_paths(x, up)
	}
	right := x + 1
	if right < n && grid[y][right] == next_height {
		result += count_paths(right, y)
	}
	down := y + 1
	if down < k && grid[down][x] == next_height {
		result += count_paths(x, down)
	}
	cnt[y][x] = result
	return result
}

