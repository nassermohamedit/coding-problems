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
var set map[int64][]int64

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
	set = make(map[int64][]int64)
}

func main() {
	in.Scan();
	line := in.Text();
	arr := make([]int, 0, 50)
	db := make([][][]int, 10, 10)
	vals := strings.Split(line, " ")
	for _, str := range vals {
		int_val, _ := strconv.Atoi(str)
		arr = append(arr, int_val)
	}
	for i := 0; i < 10; i++ {
		preCompt(i, db)
	}
	var ans int64 = 0
	for _, x := range arr {
		ans += compt(int64(x), 75, db)
	}
	fmt.Println(ans)
}

func preCompt(i int, db [][][]int) {
	db[i] = make([][]int, 0, 10)
	if i == 0 {
		db[i] = append(db[i], append(make([]int, 0, 1), 1))
		return
	}
	a := make([]int, 0, 1)
	a = append(a, i)
	for j := 1; j < 10; j++ {
		b := nextGen(a)
		db[i] = append(db[i], b)
		a = b
		var finish = true
		for _, x := range a {
			if x > 9 {
				finish = false
				break
			}
		}
		if finish {
			break
		}
		for _, x := range a {
			if x == i {
				finish = true
				break
			}
		}
		if finish {
			break
		}
	}
}

func nextGen(els []int) []int {
	b := make([]int, 0, 20)
	for _, x := range els {
		for _, y := range f(x) {
			b = append(b, y)
		}
	}
	return b
}

func f(x int) []int {
	if x == 0 {
		ret := make([]int, 0, 1)
		ret = append(ret, 1)
		return ret
	}
	b, x1, x2 := split(int64(x))
	if b {
		ret := make([]int, 0, 2)
		ret = append(ret, int(x1))
		ret = append(ret, int(x2))
		return ret
	}
	ret := make([]int, 0, 1)
	return append(ret, x*2024)
}

func compt(x int64, n int, db [][][]int) int64 {
	if n == 0 {
		return 1
	}
	if memo, exist := set[x]; exist && memo[n] > 0 {
		return memo[n]
	} 
	if x < 10 {
		j := min(n, len(db[x]))
		np := n - j
		var result int64 = 0
		for _, i := range db[x][j - 1] {
			result += compt(int64(i), np, db)
		}
		updateSet(x, n, result)
		return result
	}
	splt, x1, x2 := split(x)
	if splt {
		result :=  compt(x1, n - 1, db) + compt(x2, n - 1, db)
		updateSet(x, n, result)
		return result
	}
	result := compt(x*2024, n - 1, db)
	updateSet(x, n, result)
	return result
}


func updateSet(x int64, n int, result int64) {
	memo, exist := set[x]
	if exist {
		memo[n] = result
	} else {
		memo = make([]int64, 80, 80)
		memo[n] = result
		set[x] = memo
	}
}

func noDigits(x int64) int {
	result := 1
	for x/10 > 0 {
		result++
		x /= 10
	}
	return result
}

func split(k int64) (bool, int64, int64) {
	digits := 1
	x := k
	for x/10 > 0 {
		x /= 10
		digits++
	}
	if digits % 2 == 0 {
		order := pow(digits / 2)
		return true, k / int64(order), k % int64(order)
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

func min(a int, b int) int {
	if a <= b {
		return a
	}
	return b
}
