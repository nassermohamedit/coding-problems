/**
 * tags: greedy, impl
 * statement: https://codeforces.com/problemset/problem/1923/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MonstersAttack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[300007];
        int[] x = new int[300007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            for (int i = 1; i <= n; ++i) {
                x[i] = 0;
            }
            for (int i = 0; i < n; ++i) {
                int p = Math.abs(sc.nextInt());
                x[p] += a[i];
            }
            String ans = "Yes";
            int delta = 0;
            for (int i = 1; i <= n; ++i) {
                if (x[i] <= 0) {
                    if (i < n) x[i + 1] += x[i];
                    continue;
                }
                int d = i - delta;
                int q = x[i]/k;
                if (x[i] % k != 0) ++q;
                if (d - q < 0) {
                    ans = "No";
                    break;
                }
                if (i < n) x[i + 1] -= q * k - x[i];
                x[i] = 0;
                delta += q;
            }
            System.out.println(ans);
        }
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

