/**
 * tags: strings
 * statement: https://codeforces.com/problemset/problem/1927/A
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MakeItWhite {

    static int solveCase(int n, String s) {
        int i = 0, j = n-1;
        while (s.charAt(i) == 'W') ++i;
        while (s.charAt(j) == 'W') --j;
        return j - i + 1;
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

