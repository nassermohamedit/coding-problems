import java.io.*;
import java.util.*;

/**
 * tags: impl
 * statement: https://codeforces.com/problemset/problem/1950/C
 */


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            String[] hm = s.split(":");
            String am = "PM";
            int h = Integer.parseInt(hm[0]);
            String hs;
            if (h < 12) {
                if (h == 0) h = 12;
                hs = String.valueOf(h);
                am = "AM";
            }
            else {
                if (h > 12) h = h - 12;
                hs = String.valueOf(h);
            }
            if (hs.length() == 1) hs = "0" + hs;
            out.write(hs + ":" + hm[1] + " " + am + "\n");
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

