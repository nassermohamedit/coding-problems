/**
 * tags: strings, ca
 * statement: https://codeforces.com/problemset/problem/1935/A:
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class EntertainmentInMac {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder s = new StringBuilder(sc.next());
            StringBuilder sr = new StringBuilder(s).reverse();
            if (s.compareTo(sr) <= 0) System.out.println(s);
            else System.out.println(sr.toString() + s);
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

