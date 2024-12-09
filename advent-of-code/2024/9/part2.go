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
	var capa = make([]int, n/2 + 1, n/2 + 1)
	var idxs = make([]int, n, n)
	for i, c := range line {
		a[i] = int(c - '0')
		if i == 0 {
			idxs[i] = 0
		} else {
			idxs[i] = idxs[i-1] + a[i-1]
		}
		if i%2 == 1 {
			capa[i/2] = a[i]
		}
	}
	ans := 0
	var strt = n - 1
	strt -= strt % 2
	outer:
	for i := strt; i >= 0; i -= 2 {
		for j := 1; j < i; j += 2 {
			k := j / 2
			if capa[k] >= a[i] {
				ans += compt(i/2, idxs[j] + a[j] - capa[k], a[i])
				capa[k] -= a[i]
				continue outer
			}
		}
		ans += compt(i/2, idxs[i], a[i])
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

