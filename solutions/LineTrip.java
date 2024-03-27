/**
 * tags: math, greedy
 * statement: https://codeforces.com/problemset/problem/1901/A
 */

import java.io.*;
import java.util.*;

public class LineTrip {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[57];
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            for (int i = 1; i <= n; ++i) a[i] = sc.nextInt();
            int max = 0;
            for (int i = 1; i <= n; ++i) {
                int d = a[i] - a[i - 1];
                if (d > max) max = d;
            }
            out.write(Math.max(max, 2 * (x - a[n])) + "\n");
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

