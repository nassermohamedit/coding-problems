
import java.io.*;
import java.util.*;


/**
 * tags: math
 *
 * statement: https://codeforces.com/contest/1954/problem/A
 */

public class PaintingTheRibbon {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
          int n = sc.nextInt();
          int m = sc.nextInt();
          int k = sc.nextInt();
          if (k >= n - 1 || m == 1) {
              out.write("No\n");
              continue;
          }
          int q = n/(n - k - 1);
          int r = (n%(n - k - 1) > 0)? 1: 0;
          if (m >= q + r) {
              out.write("Yes\n");
              continue;
          }
          out.write("No\n");
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

