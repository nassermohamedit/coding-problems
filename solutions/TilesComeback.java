
import java.io.*;
import java.util.*;

/**
 * tags: greedy, ca
 *
 * statement: https://codeforces.com/contest/1851/problem/C
 */


public class TilesComeback {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] c = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                c[i] = sc.nextInt();
            }
            int i = 0;
            int a = 0;
            int j = 0;
            while (a < k && i < n) {
                if (c[i] == c[0]) {
                    ++a;
                    j = i;
                }
                ++i;
            }
            if (a < k) {
                out.write("No\n");
                continue;
            }
            if (c[0] == c[n - 1]) {
                out.write("Yes\n");
                continue;
            }
            i = n - 1;
            int l = n - 1;
            a = 0;
            while (a < k && i >= 0) {
                if (c[i] == c[n - 1]) {
                    ++a;
                    l = i;
                }
                --i;
            }
            if (a < k || j > l) {
                out.write("No\n");
            } else {
                out.write("Yes\n");
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

