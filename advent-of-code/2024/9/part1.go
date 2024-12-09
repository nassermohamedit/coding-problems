package main

import(
	"os"
	"bufio"
	"fmt"
)


var fname = "in"
var in *bufio.Scanner

func init() {
	f, _ := os.Open(fname)
	in = bufio.NewScanner(f)
}


func main() {
	in.Scan()
	var line = in.Text()
	var n = len(line)
	var a = make([]int, n, n)
	for i, c := range line {
		a[i] = int(c - '0') 
	}
	l, r := 0, n - 1
	if r % 2 == 1 {
		r--
	}
	capa := -1
	idx := 0
	ans := 0
	for l <= r {
		if l % 2 == 0 {
			ans += compt(l/2, idx, a[l])
			idx += a[l]
			l++
			capa = a[l]
			continue
		}
		if capa >= a[r] {
			capa -= a[r]
			ans += compt(r/2, idx, a[r])
			idx += a[r]
			a[r] = 0
			r -= 2
		} else {
			a[r] -= capa
			ans += compt(r/2, idx, capa)
			idx += capa
			l++
		}
	}
	fmt.Println(ans)
}


func compt(id int, idx int, k int) int {
	sum := 0
	for i := 0; i < k; i++ {
		sum += i
	}
	return id * (sum + idx * k)
}

