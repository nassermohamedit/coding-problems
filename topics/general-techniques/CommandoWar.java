import java.io.*;
import java.util.*;

/**
 * Statement: https://onlinejudge.org/external/117/11729.pdf
 */

public class CommandoWar {

    static Scanner in = new Scanner(System.in);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        SortedMap<Integer, Integer> pq = new TreeMap<>((a, b) -> b - a);
        int j = 1;
        while (true) {
            int n = in.nextInt();
            if (n == 0) break;
            for (int i = 0; i < n; ++i) {
                int b = in.nextInt();
                int t = in.nextInt();
                pq.put(t, pq.getOrDefault(t, 0) + b);
            }
            int ans = Integer.MIN_VALUE;
            int elapsed = 0;
            while (!pq.isEmpty()) {
                Integer k = pq.firstKey();
                elapsed += pq.get(k);
                ans = Math.max(ans, elapsed + k);
                pq.remove(k);
            }
            out.write("Case " + j + ": " + ans + "\n");
            ++j;
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

