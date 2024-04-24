/**
 * Statement: https://codeforces.com/problemset/problem/1948/D
 */

import java.io.*;
import java.util.*;


public class TandemRepeats {

    static Scanner in = new Scanner(System.in);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            int n = s.length();
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < n; ++i) {
                int k = 0;
                int j;
                int l = i;
                for (j = 0; i + j < n; ++j) {
                    if (j >= l) {
                        l = -1;
                        max = Math.max(max, k);
                        k = 0;
                    }
                    char c = s.charAt(j);
                    char d = s.charAt(i + j);
                    if (c == '?' || d == '?' || c == d) {
                        if (l == -1) {
                            l = i + j;
                            k = 0;
                        }
                        ++k;
                    } else {
                        k = 0;
                        l = -1;
                    }
                }
                if (j == l) {
                    max = Math.max(max, k);
                }
            }
            out.write(2*max + "\n");
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

