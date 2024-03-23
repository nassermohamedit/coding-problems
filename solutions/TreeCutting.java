import java.io.*;
import java.util.*;

/**
 * tags: dfs, trees, binary search, impl
 * https://codeforces.com/problemset/problem/1946/C
 */

public class TreeCutting {

    static int comps(int n, List<List<Integer>> adj, int x) {
        Deque<Integer> dfs = new ArrayDeque<>();
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        dfs.addLast(0);
        int components = 0;
        while (!dfs.isEmpty()) {
            int u = dfs.getLast();
            if (visited[u] == -1) {
                visited[u] = 0;
                for (int v : adj.get(u)) {
                    if (visited[v] == -1) dfs.addLast(v);
                }
            }
            else {
                for (int v: adj.get(u)) {
                    if (visited[v] >= x) ++components;
                    else visited[u] += visited[v];
                }
                ++visited[u];
                dfs.pollLast();
            }
        }
        if (visited[0] >= x) ++components;
        return components;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) adj.add(new ArrayList<>());
            for (int i = 0; i < n - 1; ++i) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int l = 1,  r = n;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (comps(n, adj, mid) > k) {
                    l = mid + 1;
                }
                else r = mid - 1;
            }
            out.write(r + "\n");
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

