
/**
 * tags: impl
 * statement: https://codeforces.com/contest/1946/problem/A
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[100007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; ++i) {
                a[i] = sc.nextInt();
            }
            if (n == 1) {
                out.write(1 + "\n");
                continue;
            }
            Arrays.sort(a, 1, n + 1);
            int mid = n / 2 + n % 2;
            int ans = 0;
            int i = mid;
            while (i <= n && a[i] == a[mid]) {
                ++i;
                ++ans;
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

