/**
 * tags: sorting, impl, two pointers
 * statement: https://codeforces.com/problemset/problem/1928/B
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Equalize {

    static int solveCase(int n, int[] arr) {
        Arrays.sort(arr, 0, n);
        Set<Integer> subseq = new HashSet<>();
        int max = 0;
        int i = 0;
        int s = 0;
        while (i < n) {
            while (arr[i] - arr[s] < n && i <n) {
                subseq.add(arr[i++]);
            }
            int k = subseq.size();
            if (k > max) max = k;
            subseq.remove(arr[s]);
            s++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] arr = new int[200005];
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

