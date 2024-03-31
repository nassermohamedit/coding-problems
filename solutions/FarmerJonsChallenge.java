import java.io.*;
import java.util.*;

/**
 * tags: ca, math
 * statement: https://codeforces.com/contest/1942/problem/A
 */

public class FarmerJonsChallenge {

    static void solve(int n, int k,BufferedWriter out) throws IOException {
        if (k == 1) {
            for (int i = 1; i <= n; ++i) {
                out.write(i + " ");
            }
        }
        else if (k == n) {
            for (int i = 1; i <= n; ++i) {
                out.write("1 ");
            }
        }
        else out.write("-1");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            solve(n, k, out);
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

