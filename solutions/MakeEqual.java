/**
 * tags: impl, greedy
 * statement: https://codeforces.com/problemset/problem/1931/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class MakeEqual {

    static String solveCase(int n, int[] arr) {
        int q = 0;
        for (int i=0; i<n; i++) {
            q += arr[i];
        }
        q = q / n;
        int c = 0;
       for (int i = n - 1; i >= 0; --i) {
           if (arr[i] < q) c += q - arr[i];
           else if (arr[i] > q) {
               c = c - arr[i] + q;
               if (c < 0) return "No";
           }
       }
       return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] arr = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solveCase(n, arr));
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

