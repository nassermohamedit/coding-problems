/**
 * tags: greedy
 * statement: https://codeforces.com/problemset/problem/1945/D
 */

import java.io.*;
import java.util.*;

public class SeraphimTheOwl {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        int[] b = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
            for (int i = 0; i < n; ++i) b[i] = sc.nextInt();
            int k = n - 1;
            long ans = 0;
            while (k >= m) {
                ans += Math.min(b[k], a[k]);
                --k;
            }
            long bs = 0;
            long min = a[m - 1];
            for (int i = m - 1; i >= 0; --i) {
                long v = bs + a[i];
                if (v < min) min = v;
                bs += b[i];
            }
            ans += min;
            out.write(ans + "\n");
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
}

