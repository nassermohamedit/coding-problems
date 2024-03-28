import java.io.*;
import java.util.*;

/**
 * tags: math, impl, bf
 * statement: https://codeforces.com/problemset/problem/1950/D
 */


public class Main {

    static boolean solveCase(int n, int[] bd) {
        if (n == 1) return true;
        boolean ans = false;
        for (int d: bd) {
            if (d == 0 || d == 1) continue;
            if (n%d == 0) ans = solveCase(n/d, bd);
            if (ans) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] bd = new int[33];
        char[] d = {'0', '1'};
        int k = 0;
        for (char a: d) {
            for (char b: d) {
                for (char c: d) {
                    for (char g: d) {
                        for (char e : d) {
                            bd[k] = Integer.parseInt("" + a + b + c + g + e);
                            ++k;
                        }
                    }
                }
            }
        }
        bd[k] = 100000;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (solveCase(n, bd)) out.write("Yes\n");
            else out.write("No\n");
        }
        out.flush();
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

    public long nextLong() {
        return Long.parseLong(next());
    }
}

