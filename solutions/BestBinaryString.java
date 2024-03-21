/**
 * tags: ca, greedy
 * statement: https://codeforces.com/problemset/problem/1837/C
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BestBinaryString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            StringBuilder ans = new StringBuilder();
            char c = '0';
            for (int i = 0; i < n; ++i) {
                if (s.charAt(i) != '?') c = s.charAt(i);
                ans.append(c);
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

