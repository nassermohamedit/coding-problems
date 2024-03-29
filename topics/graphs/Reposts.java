import java.io.*;
import java.util.*;

/**
 * statement: https://codeforces.com/problemset/problem/522/A
 *
 * idea: represent the network such that if (x reposted y) then there is a directed edge from y to x.
 * perform a depth-first search to compute the paths and their lengths.
 * since each user only reposts from exactly one user, the graph is a tree, so all the paths ends at leaf nodes
 * time = O(n) (|E| = |V| - 1)
 */

public class Reposts {
    static int dfs(String u, Map<String, List<String>> adj) {
        if (!adj.containsKey(u)) return 1;
        int max = 0;
        for (String v: adj.get(u)) {
            max = Math.max(max, 1 + dfs(v, adj));
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, List<String>> adj = new HashMap<>();
        int n = sc.nextInt();
        while (n-- > 0) {
            String u = sc.next().toLowerCase();
            sc.next();
            String v =sc.next().toLowerCase();
            if (!adj.containsKey(v))
                adj.put(v, new ArrayList<>());
            adj.get(v).add(u);
        }
        out.write(dfs("polycarp", adj) + "");
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

