/**
 * tags: strings
 * statement: https://codeforces.com/problemset/problem/1941/C
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RudolfAndTheUglyString {

    static int solveCase(int n, String s) {
        int ans = 0;
        int i = 0;
        while (i < n) {
            if (s.startsWith("mapie", i)) {
                ++ans;
                i += 5;
            }
            else if (s.startsWith("map", i) || s.startsWith("pie", i)) {
                ++ans;
                i += 3;
            }
            else ++i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(solveCase(n, s));
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

