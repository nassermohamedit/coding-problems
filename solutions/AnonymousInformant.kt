// https://codeforces.com/problemset/problem/1893/A

import java.util.*


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val arr = Array(2*100000 + 5) {0}
    while (t-- > 0) {
        val n = sc.nextInt()
        val k = sc.nextLong()
        for (i in 1..n) {
            arr[i] = sc.nextInt()
        }
        println(solveCase(n, k, arr))
    }

}

fun solveCase(n: Int, k: Long, arr: Array<Int>): String {
    var j = n
    var shifts= 0
    val l = if (k < n) k.toInt() else n
    for (i in 1..l) {
        if (arr[j] > n) return "No"
        shifts = (shifts + arr[j]) % n
        j = n - shifts
    }
    return "Yes"
}

