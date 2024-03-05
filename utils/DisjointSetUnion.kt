
class DisjointSetUnion(val n: Int, barr: Array<Int>? = null) {
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

