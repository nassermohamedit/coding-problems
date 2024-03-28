import java.io.*;
import java.util.*;

/**
 * tags: impl
 * statement: https://codeforces.com/problemset/problem/1950/B
 */

public class Upscailing {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<StringBuilder> l = new ArrayList<>();
            l.add(new StringBuilder());
            l.add(new StringBuilder());
            String[] s = {"##", ".."};
            int k = 0;
            for (int i = 0; i < n; ++i) {
                l.getFirst().append(s[k]);
                k = (k + 1)%2;
            }
            k = 1;
            for (int i = 0; i < n; ++i) {
                l.get(1).append(s[k]);
                k = (k + 1)%2;
            }
            k = 0;
            for (int i = 0; i < n; i++) {
                out.write(l.get(k).toString() + "\n");
                out.write(l.get(k).toString() + "\n");
                k = (k + 1)%2;
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

