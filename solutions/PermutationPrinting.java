import java.io.*;
import java.util.*;

/**
 * tags: ca, permutations
 *
 * statement: https://codeforces.com/problemset/problem/1930/B
 *
 */


public class PermutationPrinting {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i <= n/2; ++i) {
                out.write(i + " " + (n - i + 1) + " ");
            }
            if (n % 2 == 1)
                out.write("" + (n/2 + 1));
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

