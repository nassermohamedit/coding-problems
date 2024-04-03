import java.io.*;
import java.util.*;

/**
 * tags: graphs, greedy
 * 
 * statement: https://codeforces.com/problemset/problem/1764/C
 */

public class DoremyCityConstruction {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a, 0, n);
            if (a[0] == a[n - 1]) {
                out.write(n/2 + "\n");
                continue;
            }
            long ans = 0;
            int i = 0;
            while (i < n) {
                int j = i;
                while (j < n && a[j] == a[i]) {
                    ++j;
                }
                int sup = n - j;
                int inf = i;
                int c = j - i;
                int p = (long) inf * sup + Math.max((long) inf * c , (long) sup * c);
                ans = Math.max(ans, p);
                i = j;
            }
            out.write(ans + "\n");
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

