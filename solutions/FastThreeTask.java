/**
 * tags: math
 * statement: https://codeforces.com/problemset/problem/1933/C
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class FastThreeTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[100007];
        while (t-- > 0) {
            int  n = sc.nextInt();
            int s = 0;
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
                s += a[i];
            }
            int r = s % 3;
            int ans;
            if (r == 0) ans = 0;
            else if (r == 2) ans = 1;
            else {
                ans = 2;
                for (int i = 0; i < n; ++i) {
                    if (a[i] % 3 == 1) {
                        --ans;
                        break;
                    }
                }
            }
            System.out.println(ans);
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

