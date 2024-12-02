package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	in, _ := os.Open("in")
	defer in.Close()

	scanner := bufio.NewScanner(in)
	answer := 0

	for scanner.Scan() {
		line := scanner.Text()
		parts := strings.Fields(line)
		levels := make([]int, len(parts))
		for i, part := range parts {
			levels[i], _ = strconv.Atoi(part)
		}
		if isSafe(levels) {
			answer++
		} else {
			for i := 0; i < len(levels); i++ {
				new := make([]int, 0, len(levels) - 1)
				new = append(new, levels[:i]...)
				new = append(new, levels[i + 1:]...)
				if isSafe(new) {
					answer++
					break
				}
			}
		}
	}
	fmt.Println(answer)
}


func isSafe(arr []int) bool {
	if len(arr) < 2 {
		return false 
	}
	monotony := arr[1] > arr[0]
	for i := 1; i < len(arr); i++ {
		d := arr[i] - arr[i - 1]
		if d < -3 || d > 3 || d == 0 {
			return false
		}
		if (arr[i] > arr[i - 1]) != monotony {
			return false
		}
	}
	return true
}
