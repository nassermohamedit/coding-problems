import java.io.*;
import java.util.*;

/**
 * tags: geometry
 * statement: https://codeforces.com/contest/1942/problem/C1
 */

public class BessieBirthdayCake {

    static long solve(int n, int x, int[] v) {
        Arrays.sort(v, 0, x);
        int c = 0;
        for (int i = 0; i < x; ++i) {
            int d = v[(i + 1) % x] - v[i];
            if (d < 0) d += n;
            if (d == 2) ++c;
        }
        return c + x - 2;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] v = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int i = 0; i < x; ++i) v[i] = sc.nextInt() - 1;
            out.write(solve(n, x, v) + "\n");
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




