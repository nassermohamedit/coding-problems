// https://codeforces.com/problemset/problem/1829/E

import java.util.*
import java.util.HashSet

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val a = Array(1000 + 3) {Array(1000 + 3) {0}}
    val visited = Array(1000 + 3) {Array(1000 + 3) {false}}
    while (t-- > 0) {
        val n = sc.nextInt()
        val m = sc.nextInt()
        for (i in 1..n) {
            for (j in 1..m) {
                a[i][j] = sc.nextInt()
                visited[i][j] = false
            }
        }
        println(solveCase(n, m, a, visited))
    }
}

data class Cell(val i: Int, val j: Int) {
    fun neighbors(n: Int, m: Int): Iterator<Cell> {
        return sequence {
            if (i > 1) yield(Cell(i-1, j))
            if (j > 1) yield(Cell(i, j-1))
            if (i < n) yield(Cell(i+1, j))
            if (j < m) yield(Cell(i, j+1))
        }.iterator()
    }
}

fun solveCase(n: Int, m: Int, a: Array<Array<Int>>, visited: Array<Array<Boolean>>): Int {
    var answer = 0
    val queue: Queue<Cell> = ArrayDeque()
    for (i in 1..n) {
        for (j in 1..m) {
            if (a[i][j] == 0 || visited[i][j])
                continue
            val s = Cell(i, j)
            queue.offer(s)
            visited[s.i][s.j] = true
            var volume = 0
            while (queue.isNotEmpty()) {
                val v = queue.poll()
                volume += a[v.i][v.j]
                for (c in v.neighbors(n, m)) {
                    if (a[c.i][c.j] != 0 && !visited[c.i][c.j]) {
                        queue.offer(c)
                        visited[c.i][c.j] = true
                    }
                }
            }
            if (volume > answer) answer = volume
        }
    }
    return answer
}

