/**
 * tags: dp, impl, bf
 * statement: https://codeforces.com/problemset/problem/1941/D
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RudolfAndTheBallGame {

    static Set<Integer> solveCase(int n, int m, int x, int[] r, int[] d) {
        SortedSet<Integer> g = new TreeSet<>();
        SortedSet<Integer> h = new TreeSet<>();
        g.add(x);
        for (int i=0; i<m; ++i) {
            for (int p: g) {
                if (((d[i] & 0b01)) == 0b01) h.add((p + r[i])%n);
                if (((d[i] & 0b10)) == 0b10) h.add((n + p - r[i])%n);
            }
            g.clear();
            var temp = g;
            g = h;
            h = temp;
        }
        return g;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] r = new int[1005];
        int[] d = new int[1005];
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt() - 1;
            for (int i=0; i<m; ++i) {
                r[i] = sc.nextInt();
                String c = sc.next();
                d[i] = (c.charAt(0) == '?')? 3: Integer.parseInt(c) + 1;
            }
            Set<Integer> ps = solveCase(n, m, x, r, d);
            System.out.println(ps.size());
            for (int p: ps) System.out.print((p + 1) + " ");
            System.out.println();
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

