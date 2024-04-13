import java.io.*;
import java.util.*;

/**
 * tags: games
 *
 * statement: https://codeforces.com/contest/1956/problem/B
 */

public class NeneAndTheCardGame {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[200007];
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; ++i) a[i] = 0;
            int d = 0;
            for (int i = 0; i < n; ++i) {
                int j = sc.nextInt();
                ++a[j];
                if (a[j] == 2) ++d;
            }
            out.write(d + "\n");
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

