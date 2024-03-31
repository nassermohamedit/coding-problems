import java.io.*;
import java.util.*;

/**
 * tags: math, permutations, constructive algos
 * 
 * statement: https://codeforces.com/contest/1942/problem/B
 * 
 * idea: If such permutation P exist, then it is a unique solution to the system:
 * { a_i = Mex(p_0, p_1, .., p_i) - p_i / 0 <= i < n}
 * notice that:
 *          Mex(p_0, p_1, .., p_(n-1)) = n ==> (use this to find p_(n - 1))
 *          Mex(p_0, p_1, .., p_(n-2)) = p_(n-1) ==> (use this to find p_(n-2))
 *          Mex(p_0, p_1, .., p_i) = min({p_j / i < j < n}) / 0 <= i < n - 2
 */

public class BessieAndMex {

    static void solve(int n, int[] a) {
        if (n == 1) {
            a[0] = 0;
            return;
        }
        a[n - 1] = n - a[n - 1];
        a[n - 2] = a[n - 1] - a[n - 2];
        int min = Math.min(a[n - 1], a[n - 2]);
        for (int i = n - 3; i >= 0; --i) {
            a[i] = min - a[i];
            min = Math.min(min, a[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[200007];
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
            solve(n, a);
            for (int i = 0; i < n; ++i) {
                out.write(a[i] + " ");
            }
            out.write("\n");
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

