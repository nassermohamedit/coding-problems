// https://codeforces.com/problemset/problem/1829/F

import java.util.Scanner


fun main() {

    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val counts = Array(205) {0}
    while (t-- > 0) {
        val n = sc.nextInt()
        val m = sc.nextInt()
        for (i in 1..n) {
            counts[i] = 0
        }
        for (i in 1..m) {
            counts[sc.nextInt()] += 1
            counts[sc.nextInt()] += 1
        }
        println(solveCase(n, counts))
    }
}

fun solveCase(n: Int, counts: Array<Int>): String {
    var xy = 0
    for (i in 1..n) {
        if (counts[i] == 1) {
            xy++
        }
    }
    val x: Int = n - xy - 1
    val y: Int = xy / x
    return "$x $y"
}

