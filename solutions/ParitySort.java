
import java.io.*;
import java.util.*;

/*
 * tags: sorting
 *
 * statement: https://codeforces.com/contest/1851/problem/B
 */


public class ParitySort {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        int[] b = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
                b[i] = a[i];
            }
            Arrays.sort(a, 0, n);
            boolean ans = true;
            for (int i = 0; i < n; ++i) {
                if (b[i]%2 != a[i]%2) {
                    ans = false;
                    break;
                }
            }
            if (ans) {
                out.write("Yes\n");
            } else {
                out.write("No\n");
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

