/**
 * tags: greedy, impl
 * statement: https://codeforces.com/problemset/problem/1948/B
 */

import java.io.*;
import java.util.*;

public class ArrayFix {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[55];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            boolean ans = true;
            int i = n - 2;
            while (i >= 0 && ans) {
                if (a[i] > a[i + 1]) {
                    int l = a[i + 1];
                    while (a[i] > 0) {
                        int r = a[i] % 10;
                        if (r > l) {
                            ans = false;
                            break;
                        }
                        l = r;
                        a[i] /= 10;
                    }
                    a[i] = l;
                }
                --i;
            }
            if (ans) out.write("Yes\n");
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
}

