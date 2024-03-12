/**
 * tags: bf, strings
 * statement: https://codeforces.com/problemset/problem/1931/A
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class RecoveringASmallString {

    static String solveCase(int n) {
        for (int a = 'a'; a <= 'z'; ++a) {
            for (int b = 'a'; b <= 'z'; ++b) {
                for (int c = 'a'; c <= 'z'; ++c) {
                    if (a + b + c - 3 * 'a' + 3 == n) {
                        return "" + (char) a + (char) b + (char) c;
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] arr = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solveCase(n));
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

