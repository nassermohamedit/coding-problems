/**
 * tags: graphs, dsu, dfs, classic
 * statement: https://codeforces.com/problemset/problem/1167/C 
*/

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.StringTokenizer



fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val dsu = Array(n) {-1}
    for (i in 0..<m) {
        val k = sc.nextInt()
        if (k > 0) {
            val a = sc.nextInt() - 1
            for (j in 0..<k - 1) {
                union(dsu, a, sc.nextInt() - 1)
            }
        }
    }
    for (i in 0..<n) {
        print("${-dsu[find(dsu, i)]} ")
    }
}

fun find(arr: Array<Int>, i: Int): Int {
    if (arr[i] < 0) return i
    arr[i] = find(arr, arr[i])
    return arr[i]
}

fun union(arr: Array<Int>, i: Int, j: Int) {
    val a = find(arr, i)
    val b = find(arr, j)
    if (a != b) {
        if (arr[a] < arr[b]) {
            arr[a] = arr[a] + arr[b]
            arr[b] = a
        }
        else {
            arr[b] = arr[b] + arr[a]
            arr[a] = b
        }
    }
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
