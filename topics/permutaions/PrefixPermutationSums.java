
import java.io.*;
import java.util.*;

/*
 * tags: impl
 *
 * statement: https://codeforces.com/contest/1851/problem/D
 */


public class PrefixPermutationSums {

    static boolean isPermutation(int n, long[] a) {
        int[] set = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (a[i] > n || a[i] < 1) {
                return false;
            } else ++set[(int) a[i]];
        }
        for (int i = 1; i <= n; ++i) {
            if (set[i] != 1) {
                return false;
            }
        }
        return true;
    }

    static void restoreArr(int n, long[]a) {
        for (int i = n - 1; i > 0; --i) {
            a[i] -= a[i - 1];
        }
    }

    static boolean solve(int n, long[] a) {
        if (a[n - 2] != (long) n*(n + 1)/2) {
            a[n - 1] = (long) n*(n + 1)/2;
            restoreArr(n, a);
            return isPermutation(n, a);
        }
        restoreArr(n - 1, a);
        int[] set = new int[n + 1];
        int malVals = 0;
        long val = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (a[i] > n || a[i] < 1) {
                ++malVals;
                val = a[i];
            } else {
                ++set[(int) a[i]];
                if (set[(int) a[i]] > 1) {
                    ++malVals;
                    val = a[i];
                }
            }
        }
        if (malVals > 1) {
            return false;
        }
        int sumMissing = 0;
        for (int i = 1; i <= n; ++i) {
            if (set[i] == 0) {
                sumMissing += i;
            }
        }
        return val == sumMissing;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        long[] a = new long[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n - 1; ++i) {
                a[i] = sc.nextLong();
            }
            if (solve(n, a)) {
                out.write("Yes\n");
            } else {
                out.write("No\n");
            }
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
        while (st == null || !st.hasMoreTokens()) {
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

