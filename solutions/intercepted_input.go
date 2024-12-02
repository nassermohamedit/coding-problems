package main

// https://codeforces.com/contest/2037/problem/B

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"strconv"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout);
	defer writer.Flush();
	in, _ := reader.ReadString('\n');
	in = strings.TrimSpace(in);
	t, _ := strconv.Atoi(in);
	for i := 0; i < t; i++ {
		in, _ = reader.ReadString('\n');
		in = strings.TrimSpace(in);
		n, _ := strconv.Atoi(in)
		in, _ = reader.ReadString('\n')
		parts := strings.Fields(in)
		mm := make(map[int]int)
		for j := 0; j < n; j++ {
			k, _ := strconv.Atoi(parts[j])
			if _, exists := mm[k]; exists {
    			mm[k] += 1
			} else {
				mm[k] = 1
			}
		}
		n = n - 2
		var a, b int
		for k := range mm {
			if n % k == 0 && mm[k] > 0 {
				l := n / k
				if (l != k && mm[l] > 0) || (l == k && mm[k] > 1) {
					a = k
					b = l
					break
				}
			}
		}
		fmt.Fprintln(writer, a, " ", b)
	}
}

