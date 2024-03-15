/**
 * tags: sorting, math
 * statement: https://codeforces.com/problemset/problem/1941/A
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RudolfAndTheTicket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[105];
        int[] b = new int[105];
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            for (int i=0; i<n; ++i) a[i] = sc.nextInt();
            for (int i=0; i<m; ++i) b[i] = sc.nextInt();
            Arrays.sort(a, 0, n);
            Arrays.sort(b, 0, m);
            int j = m - 1;
            int ans = 0;
            for (int i=0; i<n; ++i) {
                while (j >= 0 && a[i] + b[j] > k) --j;
                if (j < 0) break;
                ans += j + 1;
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

