import java.io.*;
import java.util.*;

/*
 * tags: dp, graphs, dfs
 *
 * statement: https://codeforces.com/contest/1851/problem/E
 */


public class NastyaAndPotions {

    static void solve(int n, int[] c, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfsUtil(i, c, adj, visited);
            }
        }
    }

    static void dfsUtil(int s, int[] c, List<List<Integer>> adj, boolean[] visited) {
        visited[s] = true;
        long mc = 0;
        for (int u: adj.get(s)) {
            if (!visited[u]) {
                dfsUtil(u, c, adj, visited);
            }
            mc += c[u];
        }
        if (!adj.get(s).isEmpty()) {
            c[s] = (int) Math.min(c[s], mc);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] c = new int[200007];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                c[i] = sc.nextInt();
            }
            for (int i = 0; i < k; ++i) {
                c[sc.nextInt() - 1] = 0;
            }
            List<List<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                List<Integer> temp = new ArrayList<>(m);
                while (m-- > 0) {
                    temp.add(sc.nextInt() - 1);
                }
                adj.add(temp);
            }
            solve(n, c, adj);
            for (int i = 0; i < n; ++i) {
                out.write(c[i] + " ");
            }
            out.write("\n");
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

