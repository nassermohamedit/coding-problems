import java.io.*;
import java.util.*;

public class MinimizingCoins {

    static int solve(int n, int[] c, int[] dp, int p) {
        if (n == 0) return 0;
        if (dp[n] > 0) return dp[n];
        int ans = Integer.MAX_VALUE;
        while (p >= 0 && c[p] > n) --p;
        if (p < 0) return dp[n] = ans;
        if (n%c[p] == 0) return dp[n] = n/c[p];
        for (int i = p; i >= 0; --i) {
            ans = Math.min(ans, solve(n - c[i], c, dp, p));
        }
        if (ans < Integer.MAX_VALUE) ans += 1;
        return dp[n] = ans;
    }

    static Scanner in = new Scanner(System.in);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static long MODULO = 1000000007;

    public static void main(String[] args) throws IOException {
        int k = in.nextInt();
        int n = in.nextInt();
        int[] c = new int[k];
        for (int i = 0; i < k; ++i) {
            c[i] = in.nextInt();
        }
        Arrays.sort(c, 0, k);
        int[] dp = new int[1000007];
        int answer = solve(n, c, dp, k - 1);
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        out.write(answer + "");
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

