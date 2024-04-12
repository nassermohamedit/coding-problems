
import java.io.*;
import java.util.*;

/**
 * tags: math, bits
 *
 * statement: https://codeforces.com/contest/1851/problem/F
 */

public class LisaAndTheMartials {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            int[] ca = Arrays.copyOf(a, n);
            Arrays.sort(a, 0, n);
            int flip = 1;
            for (int i = 1; i < k; ++i) {
                flip |= 1 << i;
            }
            int b = a[0], c = a[1];
            int maxSim = flip ^ a[0] ^ a[1];
            for (int i = 1; i < n - 1; ++i) {
                int sim = flip ^ a[i] ^ a[i + 1];
                if (sim > maxSim) {
                    maxSim = sim;
                    b = a[i];
                    c = a[i + 1];
                }
            }
            int x = flip ^ b;
            int j = -1;
            int l = -1;
            for (int i = 0; i < n; ++i) {
                if (ca[i] == b   && j == -1) j = i + 1;
                else if (ca[i] == c && l == -1) l = i + 1;
            }
            out.write(j + " " + l + " "  + x + "\n");
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

