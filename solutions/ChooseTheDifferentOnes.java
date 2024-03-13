/**
 * tags: math
 * statement: https://codeforces.com/problemset/problem/1927/C
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ChooseTheDifferentOnes {

    static String solveCase(int n, int m, int k, int[] a, int[] b, int[] u) {
        for (int i=1; i<=k; ++i) {
            u[i] = 0;
        }
        for (int i=0; i<n; ++i) {
            if (a[i] <= k) u[a[i]] |= 0b01;
        }
        for (int i=0; i<m; ++i) {
            if (b[i] <= k) u[b[i]] |= 0b10;
        }
        int ac = 0;
        int bc = 0;
        for (int i=1; i<=k; ++i) {
            if (u[i] == 0b00) return "No";
            if ((u[i] & 0b01) == 0b01) ++ac;
            if ((u[i] & 0b10) == 0b10) ++bc;
        }
        return (ac >= k/2 && bc >= k/2)? "Yes": "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] a = new int[200005];
        int[] b = new int[200005];
        int[] u = new int[400005];
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            for (int i=0; i<n; ++i) {
                a[i] = sc.nextInt();
            }
            for (int i=0; i<m; ++i) {
                b[i] = sc.nextInt();
            }
            System.out.println(solveCase(n, m, k, a, b, u));
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

