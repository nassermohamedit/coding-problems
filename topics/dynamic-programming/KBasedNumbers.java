package mohamednasser.projects;

import java.io.*;
import java.util.*;

/**
 * Statement: https://acm.timus.ru/problem.aspx?space=1&num=1009
 */

public class Main {

    static int solve(int N, int K) {
        if (N == 1) return K;
        int ans = K*K - 1;
        int temp = K;
        for (int i = 3; i <= N; ++i) {
            int ttemp = ans;
            ans = (K - 1)*(ans + temp);
            temp = ttemp;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int K = sc.nextInt();

        out.write((K - 1) * solve(N - 1, K) + "");
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

