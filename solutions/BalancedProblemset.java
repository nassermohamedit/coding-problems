/**
 * tags: bf, math
 * statement: https://codeforces.com/problemset/problem/1925/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BalancedProblemset {

    static int solveCase(int n, int x) {
        if (n == 1) return x;
        int ans = 0;
        for (int i = 1; i * i <= x; ++i) {
            if (x % i == 0) {
                if (i >= n && ans < x/i) ans = x/i;
                if (x/i >= n && ans < i) ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(solveCase(n, x));
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

