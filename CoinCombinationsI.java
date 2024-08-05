import java.io.*;
import java.util.*;

// problem: https://cses.fi/problemset/task/1635/


public class CoinCombinationsI {
    
    final static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        long[] b = new long[x + 1];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        for (int i = 1; i <= x; ++i) {
            long ans = 0;
            for (int j: a) {
                if (i == j) ++ans;
                if (i <= j) break;
                ans = (ans + b[i - j]) % MOD;
            }
            b[i] = ans;
        } 
        out.write(b[x] + "");
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

