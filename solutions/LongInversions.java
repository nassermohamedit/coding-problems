package mohamednasser.projects;

import java.io.*;
import java.util.*;

/**
 * tags: ds, impl, ***
 *
 * statement: https://codeforces.com/problemset/problem/1955/E
 */


public class LongInversions {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        boolean[] ops = new boolean[5007];
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int ans = -1;
            for (int k = n; k > 0; --k) {
                ans = k;
                Arrays.fill(ops, false);
                int parity = 0;
                for (int i = 0; i < n - k + 1; ++i) {
                    char c = s.charAt(i);
                    if (i >= k && ops[i - k]) {
                        --parity;
                    }
                    if ((c == '0' && parity%2 == 0) || (c == '1' && parity%2 == 1)) {
                        ++parity;
                        ops[i] = true;
                    }
                }
                for (int i = n - k + 1; i < n; ++i) {
                    char c = s.charAt(i);
                    if (i - k >= 0 && ops[i - k]) {
                        --parity;
                    }
                    if ((parity%2 == 0 && c == '0') || (parity%2 == 1 && c == '1')) {
                        ans = -1;
                        break;
                    }
                }
                if (ans != -1) {
                    break;
                }
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

