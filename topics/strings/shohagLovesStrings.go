package main

// problem: https://codeforces.com/problemset/problem/2039/B

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	"strconv"
)

func main() {
	
	reader := bufio.NewReader(os.Stdin);
	writer := bufio.NewWriter(os.Stdout);
	defer writer.Flush();

	in, _ := reader.ReadString('\n');
	in = strings.TrimSpace(in);
	t, _ := strconv.Atoi(in);
	for i := 0; i < t; i++ {
		in, _ = reader.ReadString('\n');
		var a string = strings.TrimSpace(in);

		var n int = len(a);
		if n == 1 {
			fmt.Fprintln(writer, -1);
			continue;
		}
		answer := getAnswer(a);
		if answer != "" {
			fmt.Fprintln(writer, answer)
		} else {
			fmt.Fprintln(writer, -1)
		}
	}
}

func getAnswer(str string) string {
	for i := 1; i < len(str); i++ {
		if str[i] == str[i - 1] {
			return str[i - 1 : i + 1];
		}
	}
	for i := 2; i < len(str); i++ {
		if str[i - 2] != str[i - 1] && str[i - 1] != str[i] && str[i] != str[i - 2] {
			return str[i - 2 : i + 1];
		}
	}
	return "";
}


