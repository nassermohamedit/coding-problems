
import java.io.*;
import java.util.*;

/**
 * tags: impl
 *
 * statement: https://codeforces.com/contest/1954/problem/B
 */

public class MakeItUgly {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[300007];
        while (t-- > 0) {
          int n = sc.nextInt();
          for (int i = 0; i < n; ++i) {
              a[i] = sc.nextInt();
          }
          int i = 0;
          while (i < n && a[i] == a[0]) {
              ++i;
          }
          if (i == n) {
              out.write("-1\n");
              continue;
          }
          int ans = i;
          int ops;
          while (i < n) {
              ops = 0;
              while (a[i] != a[0]) ++i;
              while (i < n && a[i] == a[0]) {
                  ++ops;
                  ++i;
              }
              ans = Math.min(ans, ops);
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

