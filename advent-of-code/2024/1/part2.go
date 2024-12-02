package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	inFile, _ := os.Open("in")
	defer inFile.Close()
	writer := bufio.NewWriter(os.Stdout);
	defer writer.Flush();

	scanner := bufio.NewScanner(inFile);
	var l []int
	var cnt [1000007]int
	for scanner.Scan() {
		var v1, v2 int
		line := scanner.Text();
		fmt.Sscanf(line, "%d %d", &v1, &v2)
		l = append(l, v1)
		cnt[v2] += 1
	}
	var answer int64 = 0;
	for i := 0; i < len(l); i++ {
		answer += int64(l[i] * cnt[l[i]])
	}
	fmt.Fprintln(writer, answer)
}


