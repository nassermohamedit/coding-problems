import java.io.*;
import java.util.*;

/**
 * tags: math, greedy
 *
 * statement: https://codeforces.com/contest/1956/problem/C
 */

public class NeneMagicalMatrix {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] a = new int[200007];
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder p = new StringBuilder();
            int sum = 0;
            int ops = 2*n - 1;
            for (int i = n; i > 0; --i) {
                sum += (2*n - 2*(n - i) - 1) * i;
                p.append(i);
                p.append(" ");
            }
            p.append("\n");
            out.write(sum + " " + ops + "\n");
            out.write("1 1 " + p);
            for (int i = 2; i <= n; ++i) {
                out.write(1 + " " + i + " " + p);
                out.write(2 + " " + i + " " + p);
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

