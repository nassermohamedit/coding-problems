/**
 * tags: dfs, graphs, classic, da
 * statement: https://codeforces.com/problemset/problem/802/J
 */

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.StringTokenizer



fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val adj = Array<MutableList<Array<Int>>>(n) { mutableListOf() }
    for (i in 1..<n) {
        val u = sc.nextInt()
        val v = sc.nextInt()
        val c = sc.nextInt()
        adj[u] += arrayOf(v, c)
        adj[v] += arrayOf(u, c)
    }
    println(solveCase(n, adj))
}

fun solveCase(n: Int, adj: Array<MutableList<Array<Int>>>): Int {
    val distances= Array(n) { -1 }
    val stack = ArrayDeque<Int>()
    val s = 0;
    distances[s] = 0
    stack.push(s)
    while (stack.isNotEmpty()) {
        val u = stack.pop()
        for (vc in adj[u]) {
            if (distances[vc[0]] < 0) {
                distances[vc[0]] = distances[u] + vc[1]
                stack.push(vc[0])
            }
        }
    }
    var answer = 0
    for (d in distances) {
        if (d > answer) answer = d
    }
    return answer
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
