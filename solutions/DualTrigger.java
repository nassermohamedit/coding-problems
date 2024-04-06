import java.io.*;
import java.util.*;

/**
 * tags: math, games
 * statement: https://codeforces.com/contest/1951/problem/A
 */

public class DualTrigger {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int c = 0;
            for (int i = 0; i < n; ++i) {
                if (s.charAt(i) == '1') ++c;
            }
            if (c % 2 == 1) {
                out.write("No\n");
                continue;
            }
            int i = 0;
            int pairs = 0;
            while (i < n) {
                if (i < n - 1 && s.charAt(i) == '1' && s.charAt(i + 1) == '1') {
                    ++pairs;
                    i += 2;
                } else ++i;
            }
            if (pairs == 0 || pairs > 1 || c > 2*pairs) out.write("Yes\n");
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

