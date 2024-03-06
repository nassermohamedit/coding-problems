/**
 * tags: dfs, graphs, implementation
 * statement: https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=547&page=show_problem&problem=4107
 * problem: determine if a graph is cactus, anc calculate its cactusness
 */

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.StringTokenizer

var n: Int = 0;
val adj = Array(20005) { mutableListOf<Int>() }
val visited = Array(20005) { 0 }
val distances = Array(20005) { 0 }

fun main() {
    val sc = Scanner(System.`in`)

    while (true) {
        n = sc.nextInt()
        val m = sc.nextInt()
        for (i in 1..m) {
            val k = sc.nextInt()
            var u = sc.nextInt() - 1
            for (j in 1..<k) {
                val v = sc.nextInt() - 1
                adj[u] += v
                adj[v] += u
                u = v
            }
        }
        println(solveCase())
        println()
    }
}
fun solveCase(): Long {
    for (i in 0..<n) {
        visited[i] = 0
        distances[i] = 0
    }
    val cycles = mutableListOf<Int>()
    if (dfs(0, -1, cycles) == -2) return 0
    for (i in 0..<n) {
        if (visited[i] == 0) return 0
    }
    var answer: Long = 1
    for (x in cycles) {
        answer *= x + 1
    }
    return answer
}

fun dfs(u: Int, p: Int, cycles: MutableList<Int>): Int {
    visited[u] = 1
    var backEdge = false
    var backVertex = 0
    for (v in adj[u]) {
        if (v == p || visited[v] == 2) continue
        if (visited[v] == 0) {
            distances[v] = distances[u] + 1
            val x = dfs(v, u, cycles)
            if (x == -1 || x == u) continue
            if (x != -2 && !backEdge) {
                backEdge = true
                backVertex = x
            }
            else return -2
        } else {
            if (backEdge) return -2
            backEdge = true
            backVertex = v
            cycles += distances[u] - distances[v] + 1
        }
    }
    visited[u] = 2
    if (backEdge) return backVertex
    return -1
}


class Scanner(private val inputStream: InputStream) {
    private var st: StringTokenizer? = null
    private val br: BufferedReader = BufferedReader(InputStreamReader(inputStream))

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            st = StringTokenizer(br.readLine())
        }
        return st!!.nextToken()
    }
    fun nextInt() = next().toInt()
}
