import java.io.*;
import java.util.*;

/**
 * tags: graphs, greedy
 * statement: https://codeforces.com/problemset/problem/1327/B
 */

public class PrincessesAndPrinces {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] daughters = new int[100007];
        boolean[] kingdoms = new boolean[100007];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i <= n; ++i) {
                daughters[i] = -1;
                kingdoms[i] = false;
            }
            List<List<Integer>> gl = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                int k = sc.nextInt();
                List<Integer> l = new ArrayList<>(k);
                while (k-- > 0) {
                    l.add(sc.nextInt());
                }
                gl.add(l);
            }
            for (int i = 0; i < n; ++i) {
                for (int k: gl.get(i)) {
                    if (!kingdoms[k]) {
                        kingdoms[k] = true;
                        daughters[i] = k;
                        break;
                    }
                }
            }
            int kingdom = -1;
            int daughter = -1;
            for (int i = 1; i <= n; ++i) {
                if (!kingdoms[i]) {
                    kingdom = i;
                    break;
                }
            }
            for (int i = 0; i < n; ++i) {
                if (daughters[i] == -1) {
                    daughter = i + 1;
                    break;
                }
            }
            if (kingdom != -1) {
                out.write("IMPROVE\n");
                out.write(daughter + " " + kingdom + "\n");
            }
            else {
                out.write("OPTIMAL\n");
            }
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

