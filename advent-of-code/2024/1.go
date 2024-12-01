package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	inFile, _ := os.Open("1.in")
	defer inFile.Close()
	writer := bufio.NewWriter(os.Stdout);
	defer writer.Flush();

	scanner := bufio.NewScanner(inFile);
	var l1, l2 []int
	for scanner.Scan() {
		var v1, v2 int
		line := scanner.Text();
		fmt.Sscanf(line, "%d %d", &v1, &v2)
		l1 = append(l1, v1)
		l2 = append(l2, v2)
	}
	sort.Ints(l1)
	sort.Ints(l2)
	var answer int64 = 0;
	for i := 0; i < len(l1); i++ {
		var d int = l1[i] - l2[i]
		if d < 0 {
			d = -d
		}
		answer += int64(d)
	}
	fmt.Fprintln(writer, answer)
}


