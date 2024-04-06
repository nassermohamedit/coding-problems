
import java.io.*;
import java.util.*;

/**
 * tags: sorting, impl
 * statement: https://codeforces.com/contest/1951/problem/C
 */

public class TicketHoarding {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
                b[i] = a[i];
            }
            Arrays.sort(b, 0, n);
            int l = k/m;
            if (k%m > 0) ++l;
            int j = l - 1;
            while (j >= 0 && b[j] == b[l - 1]) --j;
            j = l - 1 - j;
            long ans = 0;
            long c = 0;
            for (int i = 0; i < n && k > 0; ++i) {
                if (a[i] < b[l - 1]) {
                    int x = Math.min(k, m);
                    ans += (a[i] + c) * x;
                    c += x;
                    k -= x;
                }
                if (j > 0 && a[i] == b[l - 1]) {
                    int x;
                    if (k % m > 0) {
                        x = k%m;
                    }
                    else x = m;
                    --j;
                    ans += (a[i] + c) * x;
                    c += x;
                    k -= x;
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

