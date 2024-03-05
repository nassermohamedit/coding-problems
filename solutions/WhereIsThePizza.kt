/**
 * tags: dsu, implementation, fucking annoying
 * statement: https://codeforces.com/problemset/problem/1670/C
*/

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.StringTokenizer

const val MOD = 1000000007

fun main() {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val a = Array(100000 + 5) {0}
    val b = Array(100000 + 5) {0}
    val c = Array(100000 + 5) {0}
    val barr = Array(100000 + 5) {0}
    val choices = Array(100000 + 5) {false}
    while (t-- > 0) {
        val n = sc.nextInt()
        for (i in 0..<n) {
            choices[i] = false
        }
        for (i in 0..<n) {
            a[i] = sc.nextInt() - 1
        }
        for (i in 0..<n) {
            b[i] = sc.nextInt() - 1
        }
        for (i in 0..<n) {
            c[i] = sc.nextInt() - 1
        }
        println(solveCase(n, a, b, c, choices, barr))
    }
}

private fun solveCase(n: Int, a: Array<Int>, b: Array<Int>, c: Array<Int>, choices: Array<Boolean>, barr: Array<Int>): Int {
    val sets = UnionFind(n, barr)
    for (i in 0..<n) {
        sets.union(a[i], b[i])
    }
    for (i in 0..<n) {
        choices[sets.find(i)] = true
    }
    for (i in 0..<n) {
        if (c[i] >= 0) {
            choices[sets.find(c[i])] = false
        }
    }
    var answer = 1
    for (i in 0..<n) {
        if (choices[i] && sets.size(i) > 1) answer = ((answer * 2.toLong()) % MOD).toInt()
    }
    return answer
}

class UnionFind(val n: Int, barr: Array<Int>? = null) {
    private val arr: Array<Int> = barr ?: Array(n) {0}
    private var noSets = n
    val sets: Int
        get() = noSets

    init {
        for (i in 0..<n) {
            arr[i] = -1
        }
    }

    fun find(i: Int): Int {
        ensureIndex(i)
        if (arr[i] < 0) return i
        arr[i] = find(arr[i])
        return arr[i]
    }

    fun union(i: Int, j: Int) {
        val a = find(i)
        val b = find(j)
        if (a != b) {
            noSets--
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

    fun isSameSet(i: Int, j: Int): Boolean {
        return find(i) == find(j)
    }

    fun size(i: Int): Int {
        return - arr[find(i)]
    }

    private fun ensureIndex(i: Int) {
        if (i >= n) throw IndexOutOfBoundsException()
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

