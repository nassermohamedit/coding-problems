/**
 * tags: ca
 * statement: https://codeforces.com/problemset/problem/1948/A
 */

import java.io.*;
import java.util.*;

public class SpecialCharacters {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[55];
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n % 2 == 1) {
                out.write("No\n");
                continue;
            }
            StringBuilder ans = new StringBuilder();
            char[] c = {'A', 'B'};
            for (int i = 0; i < n/2; ++i) {
                ans.append(c[i%2]);
                ans.append(c[i%2]);
            }
            out.write("Yes\n" + ans + "\n");
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

