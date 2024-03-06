/**
 * tags: bfs, graphs, classic, da
 * statement: https://codeforces.com/problemset/problem/520/B
 */

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer



fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    println(solveCase(n, m))
}
fun solveCase(n: Int, m: Int): Int {
    if (n >= m) return n - m
    if (2*n == m) return 1
    val distances = Array(2*m) {-1}
    val queue = LinkedList<Int>()
    queue.offer(n)
    distances[n] = 0
    while (queue.isNotEmpty()) {
        val u = queue.poll()
        if (u == m) return distances[u]
        if (u < m && distances[2*u] == -1) {
            queue.offer(2*u)
            distances[2*u] = distances[u] + 1
        }
        if (u > n/2 && distances[u-1] == -1) {
            queue.offer(u-1)
            distances[u-1] = distances[u] + 1
        }
    }
    return 0
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
