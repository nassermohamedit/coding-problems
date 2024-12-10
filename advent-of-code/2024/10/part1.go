package main

import(
	"os"
	"bufio"
	"fmt"
)

var fname = "in"
var in *bufio.Scanner

var grid [][]int
var reach [][]int
var n = -1
var k = 0

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
	grid = make([][]int, 0, 100)
	reach = make([][]int, 0, 100)
}



func main() {
	for in.Scan() {
		line := in.Text()
		n = len(line)
		grid_row := make([]int, n, n)
		reach_row := make([]int, n, n)
		for i, d := range line {
			grid_row[i] = int(d - '0')
			reach_row[i] = -1
		}
		grid = append(grid, grid_row)
		reach = append(reach, reach_row)
		k++
	}
	ans := 0
	for i := 0; i < k; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 0 {
				set := make(map[int]bool)
				count_paths(j, i, set)
				ans += len(set)
			}
		}
	}
	fmt.Println(ans)
}


func count_paths(x int, y int, set map[int]bool) int {
	if x < 0 || x >= n || y < 0 || y >= k {
		return 0
	}
	if grid[y][x] == 9 {
		p := y*n + x
		if !set[p] {
			set[p] = true
		}
		return 1
	}
	if reach[y][x] == 0 {
		return 0
	}
	reachable := 0
	next_height := grid[y][x] + 1
	left := x - 1
	if left >= 0 && grid[y][left] == next_height {
		reachable += count_paths(left, y, set)
	}
	up := y - 1
	if up >= 0 && grid[up][x] == next_height {
		reachable += count_paths(x, up, set)
	}
	right := x + 1
	if right < n && grid[y][right] == next_height {
		reachable += count_paths(right, y, set)
	}
	down := y + 1
	if down < k && grid[down][x] == next_height {
		reachable += count_paths(x, down, set)
	}
	reach[y][x] = reachable
	return reachable
}
