// https://codeforces.com/problemset/problem/1900/C

import java.util.Deque
import java.util.LinkedList
import java.util.Scanner


fun solveCase(s: String, l: Array<Int>, r: Array<Int>): Int {
    var answer = Int.MAX_VALUE
    val stack: Deque<Int> = LinkedList<Int>()
    val missingEdges: Deque<Int> = LinkedList<Int>()
    stack.push(1)
    missingEdges.push(0)
    while (stack.isNotEmpty()) {
        val v = stack.pop()
        val noMissingEdges = missingEdges.pop()
        if (l[v] == 0 && r[v] == 0) {
            if (noMissingEdges < answer) answer = noMissingEdges
            continue
        }
        if (l[v] != 0) {
            stack.push(l[v])
            if (s[v-1] != 'L') missingEdges.push(noMissingEdges + 1)
            else missingEdges.push(noMissingEdges)
        }

        if (r[v] != 0) {
            stack.push(r[v])
            if (s[v-1] != 'R') missingEdges.push(noMissingEdges + 1)
            else missingEdges.push(noMissingEdges)
        }
    }
    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    var n: Int
    var s: String
    val l: Array<Int> = Array(3*100000 + 5) {0}
    val r: Array<Int> = Array(3*100000 + 5) {0}
    while (t-- > 0) {
        n = sc.nextInt()
        sc.nextLine()
        s = sc.nextLine()
        for (i in 1..n) {
            l[i] = sc.nextInt()
            r[i] = sc.nextInt()
        }
        println(solveCase(s, l, r))
    }
}

