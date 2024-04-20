import java.io.*;
import java.util.*;


/**
 * tags: impl
 * statement: https://codeforces.com/contest/1917/problem/A
 */

public class Main {

    static Scanner in = new Scanner(System.in);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        int[] a = new int[107];
        while (t-- > 0) {
            int n = in.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
            }
            int p = 1;
            for (int i = 0; i < n; ++i) {
                if (a[i] < 0)
                    p *= -1;
                else if (a[i] == 0)
                    p = 0;
            }
            if (p <= 0) {
                out.write("0\n");
            }
            else {
                out.write("1\n1 0\n");
            }
        }
        out.flush();
    }
}
class Scanner {

    private final BufferedReader br;
    private StringTokenizer st;

    public Scanner(InputStream in) {
        this.br = new BufferedReader(new InputStreamReader(in));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(this.br.readLine());
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

