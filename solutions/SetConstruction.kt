/**
  * tags: classic, educational, graphs, dfs
  * linek: https://codeforces.com/problemset/problem/1761/C
*/

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val adj = Array<MutableList<Int>>(100 + 5) { mutableListOf() }
    val visited = Array(100 + 5) { false }
    val answer = Array(100 + 5) { Array(100 + 5) {0} }
    while (t-- > 0) {
        val n = sc.nextInt()
        for (i in 1..n) {
            adj[i] = mutableListOf()
        }
        sc.nextLine()
        for (i in 1..n) {
            val line = sc.nextLine()
            for (j in 1..n) {
                if (line[j-1] == '1') {
                    adj[j] += i
                }
            }
        }
        for (i in 1..n) {
            answer[i][0] = 0
        }
        solveCase(n, adj, visited, answer)
        for (i in 1..n) {
            for (j in 0..answer[i][0]) {
                print("${answer[i][j]} ")
            }
            println()
        }
    }
}

fun solveCase(n: Int, adj: Array<MutableList<Int>>, visited: Array<Boolean>, answer: Array<Array<Int>>) {
    val stack = LinkedList<Int>()
    for (i in 1..n) {
        println()
        for (j in 1..n) {
            visited[j] = false
        }
        stack.clear()
        stack.push(i)
        while (stack.isNotEmpty()) {
            val u = stack.poll()
            for (v in adj[u]) {
                if (!visited[v]) {
                    stack.push(v)
                    visited[v] = true
                }
            }
            answer[i][answer[i][0] + 1] = u
            answer[i][0]++
        }
    }
}

