import java.io.*;
import java.util.*;

/**
 * tags: dfs, bf, reasoning
 *
 * statement: https://codeforces.com/problemset/problem/1800/E1
 *
 * idea: if n > 5, then we can reorder the string in any order, thus, under this constraint, it suffices
 * to check if multiset(s) == multiset(t). If n <= 5, we can apply depth-first search and check if t can be
 * reached after a random sequence of operations.
 *
 */

public class UnforgivableCurse {

    static boolean dfsFind(int n, String s, String t, Set<String> visited) {
        if (s.equals(t))
            return true;
        for (int i = 0; i <= n - 4; ++i) {
            for (int j = i + 3; j <= i + 4 && j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) continue;
                String u = swap(s, i, j);
                if (!visited.contains(u)) {
                    visited.add(u);
                    if (dfsFind(n, u, t, visited))
                        return true;
                }
            }
        }
        return false;
    }

    static String swap(String s, int i, int j) {
        return s.substring(0, i) +
                s.charAt(j) +
                s.substring(i + 1, j) +
                s.charAt(i) +
                s.substring(j + 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tests = sc.nextInt();
        Set<String> visited = new HashSet<>();
        int[] chars = new int[26];
        while (tests-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            String t = sc.next();
            for (int i = 0; i < 26; ++i)
                chars[i] = 0;
            for (char c: s.toCharArray()) {
                ++chars[c - 'a'];
            }
            for (char c: t.toCharArray()) {
                --chars[c - 'a'];
            }
            boolean no = false;
            for (int i = 0; i < 26; ++i) {
                if (chars[i] > 0) {
                    no = true;
                    break;
                }
            }
            if (no) {
                out.write("No\n");
                continue;
            }
            if (n >= 5) {
                out.write("Yes\n");
                continue;
            }
            visited.clear();
            visited.add(s);
            if (dfsFind(n, s, t, visited))
                out.write("Yes\n");
            else
                out.write("No\n");
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

