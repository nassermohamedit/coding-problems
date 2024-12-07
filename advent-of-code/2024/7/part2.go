package main

import (
	"os"
	"bufio"
	"fmt"
	"strconv"
	"strings"
)

var fname = "in"
var in *bufio.Scanner

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
}

func main() {
	var ans int64 = 0
	for in.Scan() {
		var line = in.Text()
		var vals = strings.Split(line, ":")
		var target, _ = strconv.ParseInt(vals[0], 10, 64)
		vals[1] = strings.TrimSpace(vals[1])
		var operands_line = strings.Split(vals[1], " ")
		var n = len(operands_line)
		var operands = make([]int, n, n)
		for i := 0; i < n; i++  {
			operands[i], _ = strconv.Atoi(operands_line[i])
		}
		if can_produce(operands, 1, n, target, int64(operands[0])) {
			ans += target
		}
	}
	fmt.Println(ans)
}

func can_produce(operands []int, i int, n int, target int64, result int64) bool {
	if i >= n {
		return result == target
	}
	return can_produce(operands, i + 1, n, target, result * int64(operands[i])) ||
		can_produce(operands, i + 1, n, target, result + int64(operands[i])) ||
		can_produce(operands, i + 1, n, target, result * int64(concat_fact(operands[i])) + int64(operands[i]))
}

func concat_fact(a int) int {
	var k = 10
	for a/10 > 0 {
		a /= 10
		k *= 10
	}
	return k
}

