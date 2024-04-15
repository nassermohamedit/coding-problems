package mohamednasser.projects;

import java.io.*;
import java.util.*;

/**
 * statement: https://drive.google.com/file/d/1KThpD2Bn9QKXfxmL6sPuVPR0YjPZdtAu/view?usp=drive_link
 * idea: this is a direct application of the max sub-range sum, using sliding window technique
 * tags: sliding window
 */ 

public class JillBicycleRides {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int b = sc.nextInt();
        for (int k = 1; k <= b; ++k) {
            int s = sc.nextInt();
            int[] n = new int[20007];
            for (int i = 0; i < s - 1; ++i) {
                n[i] = sc.nextInt();
            }
            int sum = 0;
            int l = -1;
            int max = Integer.MIN_VALUE;
            int ml = -1;
            int mr = -1;
            for (int i = 0; i < s - 1; ++i) {
                if (sum < 0 || l == -1) {
                    l = i;
                    sum = 0;
                }
                sum += n[i];
                if (sum >= max) {
                    if (sum > max || mr - ml + 1 < i - l + 1 || mr - ml + 1 == i - l + 1 && l < ml) {
                        max = sum;
                        ml = l;
                        mr = i;
                    }
                }
            }
            if (max >= 0) {
                out.write("The nicest part of route " + k + " is between stops " + (ml + 1) + " and " + (mr + 2) + "\n");
            } else {
                out.write("Route " + k + " has no nice parts");
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

