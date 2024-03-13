/**
 * tags: math, geometry
 * statement: https://codeforces.com/problemset/problem/1928/A
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class   RectangleCutting {

    static String solveCase(int a, int b) {
        if (a%2 == 1 && b%2 == 1) return "No";
        if (b%2 == 0) {
            a += b;
            b = a - b;
            a -= b;
        }
        if (b%2 == 0) return "Yes";
        if (a == 2*b) return "No";
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] arr = new int[200005];
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(solveCase(a, b));
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

