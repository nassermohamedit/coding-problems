
import java.io.*;
import java.util.*;

public class DiceCombinations {

    static Scanner in = new Scanner(System.in);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static long MODULO = 1000000007;

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        long[] a = new long[n + 1];
        a[1] = a[0] = 1;
        for (int i = 2; i <= n; ++i) {
            long answer = 0;
            for (int j = 1; j <= 6 && i - j >= 0; ++j) {
                answer = (answer + a[i - j]) % MODULO;
            }
            a[i] = answer;
        }
        out.write(a[n] + "");
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

