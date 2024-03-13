/**
 * tags: strings, ca
 * statement: https://codeforces.com/problemset/problem/1927/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FollowingTheString {

    static String solveCase(int n, int[] a, int[] l) {
        for (int i=0; i<='z'-'a'; ++i) l[i] = 0;
        StringBuilder str = new StringBuilder();
        for (int i=0; i<n; ++i) {
            for (int j=0; j<='z'-'a'; ++j) {
                if (l[j] == a[i]) {
                    str.append((char) (j + 'a'));
                    ++l[j];
                    break;
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] a = new int[200005];
        int[] l = new int[27];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i=0; i<n; ++i) {
                a[i] = sc.nextInt();
            }
            System.out.println(solveCase(n, a, l));
        }
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

