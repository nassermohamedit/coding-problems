package main

// https://codeforces.com/contest/2037/problem/A

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"strconv"
	"sort"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout);
	defer writer.Flush();
	in, _ := reader.ReadString('\n');
	in = strings.TrimSpace(in);
	t, _ := strconv.Atoi(in);
	a := make([]int, 23, 23)
	for i := 0; i < t; i++ {
		in, _ = reader.ReadString('\n');
		in = strings.TrimSpace(in);
		n,_ := strconv.Atoi(in)
		in, _ = reader.ReadString('\n')
		parts := strings.Fields(in)
		for j := 0; j < n; j++ {
			a[j], _ = strconv.Atoi(parts[j])
		}
		sort.Ints(a[:n])
		var ans = 0
		for j := 1; j < n; j++ {
			if a[j-1] > 0 && a[j] == a[j-1] {
				ans++
				a[j] = -1
			}
		}
		fmt.Fprintln(writer, ans)
	}
}

