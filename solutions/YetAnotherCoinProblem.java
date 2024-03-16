/**
 * tags: math
 * statement: https://codeforces.com/problemset/problem/1935/A:
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class YetAnotherCoinProblem {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = Integer.MAX_VALUE;
            for (int ones = 0; ones < 3; ++ones) {
                for (int threes = 0; threes < 2; ++threes) {
                    for (int sixs = 0; sixs < 4; ++sixs) {
                        for (int tens = 0; tens < 3; ++tens) {
                            int s = ones + threes*3 + sixs*6 + tens*10;
                            int q = (n - s)/15;
                            if (s <= n && s + q*15 == n) {
                                int c = ones + threes + sixs + tens + q;
                                if (c < ans) ans = c;
                            }
                        }
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

