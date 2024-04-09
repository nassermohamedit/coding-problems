package mohamednasser.projects;

import java.io.*;
import java.util.*;

/*
 * tags: math, impl
 * statement: https://codeforces.com/contest/1955/problem/C
 */

public class InhabitantOfTheDeepSea {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            int ans = 0;
            int i = 0;
            int j = n - 1;
            while (i < j && k > 0) {
                int min = Math.min(a[i], a[j]);
                if (k >= 2L *min) {
                    k -= 2L * min;
                    a[i] -= min;
                    a[j] -= min;
                    if (a[i] == 0) {
                        ++i;
                        ++ans;
                    }
                    if (a[j] == 0) {
                        --j;
                        ++ans;
                    }
                }
                else if (a[i] == min && min == k/2 + k%2) {
                    ++ans;
                    break;
                }
                else {
                    break;
                }
            }
            if (i == j && a[i] > 0 && a[i] - k <= 0) {
                ++ans;
            }
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

