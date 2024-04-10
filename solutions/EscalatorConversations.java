
import java.io.*;
import java.util.*;

/*
 * tags: math
 *
 * statement: https://codeforces.com/contest/1851/problem/A
 */

public class EscalatorConversations {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int g = sc.nextInt();
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                int h = sc.nextInt();
                int diff = Math.abs(h - g);
                if (diff > 0 && diff%k == 0 && diff/k <= m - 1) {
                    ++ans;
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

