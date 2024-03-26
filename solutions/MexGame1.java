/**
 * tags: games, greedy
 * statement: https://codeforces.com/problemset/problem/1943/A
 */

import java.io.*;
import java.util.*;


public class MexGame1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) a[i] = 0;
            for (int i = 0; i < n; ++i) ++a[sc.nextInt()];
            int i = 0, mex = n;
            while (i < n && a[i] > 1) ++i;
            if (i < n) {
                if (a[i] == 0) mex = i;
                else {
                    ++i;
                    while (i < n && a[i] > 1) ++i;
                    if (i < n) mex = i;
                }
            }
            out.write(mex + "\n");
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

