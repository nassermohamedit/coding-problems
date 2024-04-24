package mohamednasser.projects;

/**
 * Statement: https://codeforces.com/problemset/problem/1950/F
 */

import java.io.*;
import java.util.*;


public class Tree012 {

    static Scanner in = new Scanner(System.in);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (c != a + 1) {
                out.write("-1\n");
                continue;
            }
            if (a == 0) {
                out.write(b + "\n");
                continue;
            }
            int h = 1;
            while (a > (1 << h) - 1) {
                ++h;
            }
            b -= (1 << h) - a - 1;
            if (b > 0) {
                h += b/(a + 1);
                if (b%(a + 1) > 0) ++h;
            }
            out.write(h + "\n");
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

