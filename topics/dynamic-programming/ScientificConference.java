import java.io.*;
import java.util.*;

/**
 * Idea: Suppose that at each minute i, there is at most one report that starts at i
 * Let te[i] be the ending time of the report that starts at minute i if no report starts
 * at minute i, we can set te[i] to infinity
 * Let dp[i] be the maximum number of reports that I can attend in the time interval
 * [i, infinity] given that I am free at minute i
 * If I am free at minute j and there is an event starting at minute j, then I can either
 * attend that event, in which case I won't be free until te[j] + 1, or I can wait until minute
 * j + 1 and see if I can make a better decision
 * So the maximum number of reports that I can attend in the interval [j, infinity], dp[j],
 * is the best of these two options
 * Formally, it is: dp[j] = max(1 + dp[te[j] + 1], dp[j + 1]), given that dp[k] is known for all
 * k > j, dp[j] can be calculated in O(1)
 * Therefore, it is efficient to start computing dp from the last minute going backward in time
 * This way, at each, minute j, all the optimal decisions at minutes k > j, are known
 * Now, let's relax the assumption "at each minute i, there is at most one report that starts at i"
 * Let j >= 1, If there are multiple events starting at minute j, then if I choose to go to the
 * one with the minimum ending time, then I will get out EARLY and would have all the options that
 * I would have if I chose to do otherwise and more, so it is always optimal to consider only the
 * event with the minimum ending time
 *
 * Complexity: T(N) = O(N)
 *
 * Statement: https://acm.timus.ru/problem.aspx?space=1&num=1203
 */

public class ScientificConference {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] te = new int[30007];
        Arrays.fill(te, Integer.MAX_VALUE);
        int N = sc.nextInt();
        int l = Integer.MAX_VALUE;
        int r = -1;
        for (int i = 0; i < N; ++i) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            te[s] = Math.min(te[s], e);
            l = Math.min(l, s);
            r = Math.max(r, s);
        }
        int[] dp = new int[r + 1];
        dp[r] = 1;
        for (int i = r - 1; i >= l; --i) {
            if (te[i] >= r) dp[i] = dp[i + 1];
            else dp[i] = Math.max(1 + dp[te[i] + 1], dp[i + 1]);
        }
        out.write(dp[l] + "");
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

