import java.io.*;
import java.util.*;

/**
 * tags: graphs
 * statement: https://codeforces.com/problemset/problem/1581/B
 */

public class DiameterOfGraph {

    static boolean solve(int n, int m, int k) {
        if (m < n - 1 || m > (long) n*(n - 1)/2) return false;
        if (k < 0) return false;
        if (k == 0) return n == 1;
        if (k == 1) return m == (long) n*(n - 1)/2;
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt() - 2;
            if (solve(n, m, k)) out.write("Yes\n");
            else out.write("No\n");
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
        while (st == null || !st.hasMoreTokens() ) {
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

