/**
 * tags: greedy, math
 * statement: https://codeforces.com/problemset/problem/1941/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RudolfAnd121 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[200005];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i=0; i<n; ++i) {
                a[i] = sc.nextInt();
            }
            int i = 0;
            while (i < n-2) {
                if (a[i] < 0) break;
                if (a[i] > 0) {
                    a[i + 1] -= 2*a[i];
                    a[i + 2] -= a[i];
                    a[i] = 0;
                }
                ++i;
            }
            System.out.println((i < n-2 || a[n - 2] != 0 || a[n - 1] != 0)? "No": "Yes");
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

