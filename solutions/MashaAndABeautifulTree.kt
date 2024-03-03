// https://codeforces.com/problemset/problem/1741/D

import java.util.Scanner


fun main(args: Array<String>) {

    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val arr = Array(262144 + 5) {0}
    while (t-- > 0) {
        val m = sc.nextInt()
        for (i in 0..<m) {
            arr[i] = sc.nextInt()
        }
        println(solveCase(0, m, arr))
    }
}

fun solveCase(i: Int, n: Int, arr: Array<Int>): Int {
    if (n == 1) return 0
    if (n == 2) {
        val d = arr[i+1] - arr[i]
        return if (d == 1) 0 else if (d == -1) 1 else -1
    }
    if (!isSubPermutation(i, n, arr)) return -1
    val mid: Int = n / 2
    val left = solveCase(i, mid, arr)
    if (left == -1) return -1
    val right = solveCase(i + mid, mid, arr)
    if (right == -1) return -1
    return left + right + if (arr[i] > arr[i + mid]) 1 else 0
}

fun isSubPermutation(i: Int, n: Int, arr: Array<Int>): Boolean {
    var min = Int.MAX_VALUE
    var sum = 0
    for (j in i..<i + n) {
        if (arr[j] < min) min = arr[j]
        sum += arr[j]
    }
    return 2*(sum - n*min) == n*(n - 1)
}
