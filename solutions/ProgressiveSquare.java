
import java.io.*;
import java.util.*;

/**
 * tags: math
 * statement: https://codeforces.com/contest/1955/problem/B
 */

public class ProgressiveSquare {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        Map<Integer, Integer> vals = new HashMap<>();
        while (t-- > 0) {
            vals.clear();
            int n = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            for (int i = 0;  i < n*n; ++i) {
                int b = sc.nextInt();
                if (!vals.containsKey(b)) {
                    vals.put(b, 0);
                }
                vals.put(b, vals.get(b) + 1);
            }
            int a = Integer.MAX_VALUE;
            for (int v: vals.keySet()) {
                a = Math.min(a, v);
            }
            boolean ans = true;
            for (int i = 0; i < n && ans; ++i) {
                for (int j = 0; j < n && ans; ++j) {
                    int u = a + i*c + j*d;
                    if (!vals.containsKey(u) || vals.get(u) <= 0) {
                        ans = false;
                        break;
                    }
                    vals.put(u, vals.get(u) - 1);
                }
            }
            if (!ans) {
                out.write("No\n");
            }
            else {
                for (int x: vals.values()) {
                    if (x > 0) {
                        ans = false;
                        break;
                    }
                }
                if (!ans) {
                    out.write("No\n");
                } else {
                    out.write("Yes\n");
                }
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

