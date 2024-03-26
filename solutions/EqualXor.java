/**
 * tags: bits, ca
 * statement: https://codeforces.com/problemset/problem/1944/B
 */

import java.io.*;
import java.util.*;


public class EqualXor {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[50007];
        int[] l = new int[50007];
        int[] r = new int[50007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 1; i <= n; ++i) a[i] = 0;
            for (int i = 0; i < n; ++i) ++a[sc.nextInt()];
            for (int i = 0; i < n; ++i) sc.nextInt();
            int li = 0;
            int ri = 0;
            for (int i = 1; i <= n && (li < 2*k || ri < 2*k); ++i) {
                if (a[i] == 2) {
                    l[li++] = i;
                    l[li++] = i;
                }
                if (a[i] == 0) {
                    r[ri++] = i;
                    r[ri++] = i;
                }
            }
            for (int i = 1; i <= n && li < 2*k; ++i) {
                if (a[i] == 1) {
                    l[li] = i;
                    r[li] = i;
                    ++li;
                }
            }
            for (int i = 0; i < 2*k; ++i) {
                out.write(l[i] + " ");
            }
            out.write("\n");
            for (int i = 0; i < 2*k; ++i) {
                out.write(r[i] + " ");
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

