import java.io.*;
import java.util.*;


/**
 * Idea: To find the maximum sum sub-matrix, we can extend Kadane's algorithm to 2 dimensions.
 * Let (i, j, k, l) represent the coordinates of the sub-matrix with the maximum sum, where (i, j)
 * denote the coordinates of the top leftmost element and (k, l) denote the coordinates of the
 * bottom rightmost element. The sum of the rows from i to k has the highest maximal sub-array sum
 * among all possible consecutive rows. Otherwise, the optimal sub-matrix is not (i, *, k, *).
 * So we can compute all possible consecutive row sums and their maximum sub-array sums to find
 * which one is maximal.
 *
 * Complexity: There are O(N^2) sub-matrices of consecutive rows. For each such sub-matrix,
 * we compute the sum of its rows, which is O(N). Then we apply Kadane's algorithm to find the maximum
 * sub-array sum, which is O(N). Finally, we update the global maximum in O(1). Therefore, T(N) = O(N^3).
 * For space complexity, we need only one array of size N, to hold the sum of consecutive rows to
 * which we apply kadan's algorithm, Therefor S(N) = O(N) (excluding the actual matrix space)
 *
 * Statement: https://acm.timus.ru/problem.aspx?space=1&num=1146
 */


public class MaximumSubMatrixSum {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        int l = -1;
        int r = -1;
        int t = -1;
        int b = -1;
        int[] prefixSumRow = new int[n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(prefixSumRow, 0);
            for (int j = i ; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    prefixSumRow[k] += a[j][k];
                }
                int lmax = prefixSumRow[0];
                int s = 0;
                int ll = -1;
                int lml = 0;
                int lmr = 0;
                for (int k = 0; k < n; ++k) {
                    if (s < 0 || ll == -1) {
                        s = 0;
                        ll = k;
                    }
                    s += prefixSumRow[k];
                    if (s > lmax) {
                        lmax = s;
                        lml = ll;
                        lmr = i;
                    }
                }
                if (lmax > max) {
                    max = lmax;
                    l = lml;
                    r = lmr;
                    t = i;
                    b = j;
                }
            }
        }
        out.write(max + "");
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

