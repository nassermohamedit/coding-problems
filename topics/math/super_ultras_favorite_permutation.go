package main

// https://codeforces.com/contest/2037/problem/C 

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
		if n < 5 {
			fmt.Fprintln(writer, -1)
			continue
		}
		fmt.Fprint(writer, "2 ")
		for j := 6; j <= n; j += 2 {
			fmt.Fprint(writer, j, " ")
		}
		fmt.Fprint(writer, "4 5 1 3 ")
		for j := 7; j <= n; j += 2 {
			fmt.Fprint(writer, j, " ")
		}
		fmt.Fprintln(writer, "")
	}
}
