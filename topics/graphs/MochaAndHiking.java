import java.io.*;
import java.util.*;


/**
 * tags: graphs, ca
 * statement: https://codeforces.com/problemset/problem/1559/C
 */


public class MochaAndHiking {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[10007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; ++i) a[i] = sc.nextInt();
            int i = 1;
            while (i <= n && a[i] != 1) {
                out.write(i + " ");
                ++i;
            }
            out.write((n + 1) + " ");
            while (i <= n) {
                out.write(i + " ");
                ++i;
            }
            out.write("\n");
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

