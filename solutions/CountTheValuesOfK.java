/**
 * tags: math
 * statement: https://codeforces.com/problemset/problem/1933/C
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CountTheValuesOfk {

    static int solveCase(int l, int a, int b) {
        int ma = multiplicity(l, a);
        if (a == b) return 1 + ma;
        int mb = multiplicity(l, b);
        if (ma == 0 || mb == 0) return 1 + ma + mb;
        Set<Integer> ks = new HashSet<>();
        for (int i = 0; i <= ma; ++i) {
            for (int j = 0; j <= mb; ++j) {
                long p = (long) Math.pow(a, i) * (long) Math.pow(b, j);
                if (l % p == 0) ks.add((int) (l/p));
            }
        }
        return ks.size();
    }

    static int multiplicity(int x, int y) {
        int m = 0;
        while (x % y  == 0) {
            x /= y;
            ++m;
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();
            System.out.println(solveCase(l, a, b));
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

