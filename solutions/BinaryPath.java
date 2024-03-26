/**
 * tags: greedy, impl, strings
 * statement: https://codeforces.com/problemset/problem/1937/B
 */

import java.io.*;
import java.util.*;

public class BinaryPath {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            StringBuilder ans = new StringBuilder();
            ans.append(s1.charAt(0));
            int i = 0;
            long c = 1;
            while (i < n - 1) {
                int j = i;
                while (j < n - 1 && s2.charAt(j) == s1.charAt(j + 1)) {
                   ans.append(s2.charAt(j));
                   ++j;
               }
               if (j >= n - 1) {
                   c += j - i;
                   break;
               }
               if (s1.charAt(j + 1) == '1') {
                   ans.append(s2, j, n - 1);
                   c += j - i;
                   break;
               }
               else {
                   ans.append(s1.charAt(j + 1));
               }
               i = j + 1;
            }
            ans.append(s2.charAt(n - 1));
            out.write(ans + "\n");
            out.write(c + "\n");
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

