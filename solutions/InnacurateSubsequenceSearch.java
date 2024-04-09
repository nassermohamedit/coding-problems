package mohamednasser.projects;

import java.io.*;
import java.util.*;


/**
 * tags: ds, multiset, sliding window, impl
 *
 * statement: https://codeforces.com/problemset/problem/1955/D
 */

public class InnacurateSubsequenceSearch {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int[] a = new int[200007];
        Map<Integer, Integer> bmultiset = new HashMap<>();
        Map<Integer, Integer> amultiset = new HashMap<>();
        while (t-- > 0) {
            bmultiset.clear();
            amultiset.clear();
            int n = sc.nextInt();
            int m = sc.nextInt();
            long k = sc.nextLong();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; ++i) {
                int b = sc.nextInt();
                if (!bmultiset.containsKey(b)) {
                    bmultiset.put(b, 0);
                    amultiset.put(b, 0);
                }
                bmultiset.put(b, bmultiset.get(b) + 1);
            }
            int diff = 0;
            for (int i = 0; i < m; ++i) {
                if (bmultiset.containsKey(a[i])) {
                    amultiset.put(a[i], amultiset.get(a[i]) + 1);
                    if (amultiset.get(a[i]) <= bmultiset.get(a[i])) {
                        ++diff;
                    }
                }
            }
            int ans = 0;
            if (diff >= k) ++ans;
            for (int i = m; i < n; ++i) {
                int j = i - m;
                if (bmultiset.containsKey(a[j])) {
                    amultiset.put(a[j], amultiset.get(a[j]) - 1);
                    if (amultiset.get(a[j]) < bmultiset.get(a[j])) {
                        --diff;
                    }
                }
                if (bmultiset.containsKey(a[i])) {
                    int ai = amultiset.get(a[i]);
                    if (ai < bmultiset.get(a[i])) {
                        ++diff;
                    }
                    amultiset.put(a[i], ai + 1);
                }
                if (diff >= k) {
                    ++ans;
                }
            }
            out.write(ans + "\n");
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

