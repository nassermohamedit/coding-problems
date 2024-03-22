import java.io.*;
import java.util.*;

/**
 * tags: math, impl
 * statement: https://codeforces.com/problemset/problem/1946/B
 */

public class Main {

    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long sum = 0;
            for (int i = 1; i <= n; ++i) {
                a[i] = sc.nextInt();
                sum += a[i];
            }

            long maxSum = 0;
            long currSum = 0;
            for (int i = 1; i <= n; ++i) {
                if (a[i] < 0) {
                    if (currSum > maxSum) maxSum = currSum;
                    if (currSum + a[i] <= 0) {
                        currSum = 0;
                        continue;
                    }
                }
                currSum += a[i];
            }
            if (currSum > maxSum) maxSum = currSum;
            long ans = sum % MOD;
            if (ans < 0) ans += MOD;
            if (maxSum == 0) k = 0;
            maxSum %= MOD;
            while (k-- > 0) {
                ans += maxSum;
                ans %= MOD;
                maxSum *= 2;
                maxSum %= MOD;
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
}

