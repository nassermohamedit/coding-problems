/**
 * tags: dfs, impl
 * statement: https://codeforces.com/problemset/problem/1948/C
 */

import java.io.*;
import java.util.*;

public class ArrowPath {

    static boolean dfsFind(int n, int[][] r) {
        boolean[][] visited = new boolean[2][n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        visited[0][0] = true;
        while (!stack.isEmpty()) {
            int u = stack.pollLast();
            int i = u/n;
            int j = u%n;
            for (int k = -1; k <= 1; k+=2) {
                if (j + k >= 0 && j + k < n) {
                    int jj = j + k + r[i][j + k];
                    if (!visited[i][jj]) {
                        visited[i][jj] = true;
                        stack.addLast(i * n + jj);
                    }
                }
            }
            int ii = (i + 1) % 2;
            int jj = j + r[ii][j];
            if (jj >= 0 && jj < n && !visited[ii][jj]) {
                visited[ii][jj] = true;
                int k = ii * n + jj;
                stack.addLast(k);
            }
        }
        return visited[1][n - 1];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[][] r = new int[2][200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            String r0 = sc.next();
            String r1 = sc.next();
            for (int i = 0; i < n; ++i) {
                r[0][i] = (r0.charAt(i) == '>')? 1: -1;
            }
            for (int i = 0; i < n; ++i) {
                r[1][i] = (r1.charAt(i) == '>')? 1: -1;
            }
            if (dfsFind(n, r)) out.write("Yes\n");
            else out.write("No\n");
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

