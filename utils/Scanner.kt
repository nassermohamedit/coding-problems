import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.StringTokenizer


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
