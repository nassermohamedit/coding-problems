package main

import (
	"os"
	"bufio"
	"fmt"
	"strings"
	"strconv"
)

var fname = "in"
var in *bufio.Scanner

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
}

func main() {
	in.Scan();
	line := in.Text();
	arr := make([]int, 0, 50)
	vals := strings.Split(line, " ")
	for _, str := range vals {
		int_val, _ := strconv.Atoi(str)
		arr = append(arr, int_val)
	}
	var ans int64 = 0
	for _, i := range arr {
		ans += compt(i, 25)
	}
	fmt.Println(ans)
}

func compt(x int, n int) int64 {
	if n == 0 {
		return 1
	}
	if x == 0 {
		return compt(1, n - 1)
	}
	if b, x1, x2 := split(x); b {
		return compt(x1, n - 1) + compt(x2, n - 1)
	}
	return compt(x * 2024, n - 1)
}

func split(k int) (bool, int, int) {
	digits := 1
	x := k
	for x/10 > 0 {
		x /= 10
		digits++
	}
	if digits % 2 == 0 {
		order := pow(digits / 2)
		return true, k / order, k % order
	}
	return false, -1, -1
}

func pow(p int) int {
	result := 1
	for p > 0 {
		result *= 10
		p--
	}
	return result
}
