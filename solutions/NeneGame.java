import java.io.*;
import java.util.*;

/**
 * tags: impl
 *
 * statement: https://codeforces.com/contest/1956/problem/A
 */

public class NeneGame {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[1007];
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int q = sc.nextInt();
            for (int i = 0; i < k; ++i) {
                a[i] = sc.nextInt();
            }
            while (q-- > 0) {
                int n = sc.nextInt();
                int i = k - 1;
                while (i >= 0) {
                    while (n >= a[i]) {
                        n -= i + 1;
                    }
                    --i;
                }
                out.write(n + " ");
            }
            out.write("\n");
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

