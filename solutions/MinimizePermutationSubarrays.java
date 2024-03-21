/**
 * tags: math
 * statement: https://codeforces.com/problemset/problem/1838/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MinimizePermutationSubarrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] p = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; ++i) {
                p[sc.nextInt()] = i;
            }
            int i = 1, j = 1;
            int q = p[1], r = p[2], s = p[n];
            if ((q < r && r < s) || (s < r && r < q)) {
                i = r; j = s;
            }
            else if ((s < q && q < r) || r < q && q < s) {
                i = s; j = q;
            }
            System.out.println(i + " " + j);
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

