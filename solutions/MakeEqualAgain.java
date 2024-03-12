
/**
 * tags: implementation
 * statement: https://codeforces.com/problemset/problem/1931/C
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class MakeEqualAgain {

    static int solveCase(int n, int[] arr) {
        int answer = 0;

        int x = arr[0];
        int i = 1;
        while (i < n && arr[i] == x) {
            i++;
        }
        if (i == n) return 0;

        int y = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] == y) {
            j--;
        }

        if (x == y) return j - i + 1;
        if (n - j > i) return j + 1;
        return n - i;
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

