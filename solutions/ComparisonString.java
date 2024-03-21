/**
 * tags: math, greedy
 * statement: https://codeforces.com/problemset/problem/1837/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ComparisonString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int ans = 0;
            int c = 1;
            for (int i = 1; i < n; ++i) {
                if (s.charAt(i) == s.charAt(i - 1)) c++;
                else {
                    if (c > ans) ans = c;
                    c = 1;
                }
            }
            if (c > ans) ans = c;
            System.out.println(ans + 1);
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

