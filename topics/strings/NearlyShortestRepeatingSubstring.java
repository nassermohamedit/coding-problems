
import java.io.*;
import java.util.*;

/**
  *Idea: Check for all possible sizes from 1 to n - 1.
  * If a size k is valid, then the base string is s[0: k] or s[k: 2k]. Otherwise, k is not a valid size.
  * 
  * Complexity: The number of divisors of N (size of the string) is O(sqrt(N)).
  * For each divisor, we check if it is valid by comparing the concatenated string with the original in O(n).
  * Therefore, T(N) = O(N.sqrt(N)).
  *
  * Statement: https://codeforces.com/problemset/problem/1950/E
  * */

public class  NearlyShortestRepeatingSubstring {

    static Scanner in = new Scanner(System.in);
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            int ans = n;
            for (int size = 1; size < n && ans == n; ++size) {
                if (n % size != 0) continue;
                for (int j = 0; j <= size; j += size) {
                    int diffs = 0;
                    for (int i = 0; i < n; ++i) {
                        if (s.charAt(i) != s.charAt(j + i%size))
                            ++diffs;
                        if (diffs >= 2) {
                            break;
                        }
                    }
                    if (diffs <= 1) {
                        ans = size;
                        break;
                    }
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

