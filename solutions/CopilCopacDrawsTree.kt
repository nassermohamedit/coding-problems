// https://codeforces.com/problemset/problem/1830/A

import java.util.ArrayDeque
import java.util.Scanner


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val iterations = Array(200000 + 5) {-1}
    val edgeIndex = Array(200000 + 5) {-1}
    val adj = Array<MutableList<Array<Int>>>(200000 + 5) { mutableListOf() }
    while (t-- > 0) {
        val n = sc.nextInt()
        for (i in 0..<n) {
            iterations[i] = -1
            edgeIndex[i] = -1
            adj[i] = mutableListOf()
        }
        for (i in 0..<n-1) {
            val u = sc.nextInt()
            val v = sc.nextInt()
            adj[u-1] += arrayOf(v-1, i)
            adj[v-1] += arrayOf(u-1, i)
        }
        println(solveCase(n, adj, iterations, edgeIndex))
    }
}

fun solveCase(n: Int, adj: Array<MutableList<Array<Int>>>, iterations: Array<Int>, edgeIndex: Array<Int>): Int {
    var answer = Int.MIN_VALUE
    val queue = ArrayDeque<Int>()
    queue.offer(0)
    iterations[0] = 0
    edgeIndex[0] = n
    while (queue.isNotEmpty()) {
        val u = queue.poll()
        for (e in adj[u]) {
            if (iterations[e[0]] != -1) continue
            val v = e[0]
            val i = e[1]
            iterations[v] = if (edgeIndex[u] < i) iterations[u] else iterations[u] + 1
            edgeIndex[v] = i
            queue.offer(v)
            if (iterations[v] > answer) answer = iterations[v]
        }
    }
    return answer
}

