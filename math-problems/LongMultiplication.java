
/**
 * tags: math
 * statement: https://codeforces.com/contest/1954/problem/C
 *
 * idea: let's consider the following optimization problem:
 *          let x be an integer
 *          ab (max)
 *          a + b = x
 *          a and b are integers
 * The solution for this system is (n/2, n/2 + n%2), this pair is the closest pair that satisfies the constrain a + b = n
 * it can be shown that the product ab gets smaller as the distance bewteen the elemens of the pair gets larger and vice versa
 * The aftermentioned observation stays valid even when we add more constrains to the problem
 * SO the solution to the oroblem is to switch the digits in such a way that the distance between the final elements is minimal
 * as possible.
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            String x = sc.next();
            String y = sc.next();
            int n = x.length();
            int i = 0;
            while (i < n && x.charAt(i) == y.charAt(i))
                ++i;
            if (i == n) {
                out.write(x + "\n" + y + "\n");
                continue;
            }
            StringBuilder xx = new StringBuilder(x.substring(0, i));
            StringBuilder yy = new StringBuilder(y.substring(0, i));
            char c = x.charAt(i);
            char d = y.charAt(i);
            if (c < d) {
                char temp = c;
                c = d;
                d = temp;
            }
            xx.append(c);
            yy.append(d);
            ++i;
            while (i < n) {
                c = x.charAt(i);
                d = y.charAt(i);
                if (c < d) {
                    char temp = c;
                    c = d;
                    d = temp;
                }
                yy.append(c);
                xx.append(d);
                ++i;
            }
            out.write(xx + "\n" + yy + "\n");
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

