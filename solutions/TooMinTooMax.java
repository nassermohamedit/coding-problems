/**
 * tags: math
 * statement: https://codeforces.com/problemset/problem/1934/A
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TooMinTooMax {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[105];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i=0; i<n; ++i) a[i] = sc.nextInt();
            Arrays.sort(a, 0, n);
            int ans = Math.abs(a[0] - a[n-1]) + Math.abs(a[n-1] - a[1]) + Math.abs(a[1] - a[n-2]) + Math.abs(a[n-2] - a[0]);
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

