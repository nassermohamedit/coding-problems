import java.io.*;
import java.util.*;

/**
 * tags: impl
 * 
 * statement: https://codeforces.com/problemset/problem/1647/B
 * 
 * idea: If the grid has two distinct intersecting nice rectangles,
 * then There exist at least two intersecting black rectangles of dimensions 1x2 and 2*1,
 * So to verify the property, we brute force over all blocks of 2x2 and check if anyone contains
 * two intersecting black rectangles.
 */

public class Main {

    static boolean bfsSolve(int n, int m, char[][] grid) {
        boolean isElegant = true;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                int a = grid[i - 1][j - 1] - '0';
                int b = grid[i][j - 1] - '0';
                int c = grid[i - 1][j] - '0';
                int d = grid[i][j] - '0';
                if (a + b + c + d == 3) {
                    isElegant = false;
                    break;
                }
            }
        }
        return isElegant;
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        char[][] grid = new char[107][107];
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < n; ++i)
                grid[i] = sc.next().toCharArray();
            if (bfsSolve(n, m, grid))
                out.write("Yes\n");
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

    public long nextLong() {
        return Long.parseLong(next());
    }
}

