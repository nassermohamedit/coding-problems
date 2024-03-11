/**
 * tags: graphs, dfs, brute force
 * statement: file:///home/nasser/Downloads/Problem%20-%201130C%20-%20Codeforces-codeforces.com.mhtml
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Connect {

    static int solve(int n, int a, int b, List<String> map) {
        int ns = n*n;
        List<Integer> visited = new ArrayList<>(ns);
        for (int i=0; i<ns; i++) visited.add(-1);
        Queue<Integer> queue = new LinkedList<>();
        int islands = -1;
        boolean found = false;
        int i = a;
        while (true) {
            if (found) break;
            if (visited.get(i) == -1 && map.get(i/n).charAt(i%n) == '0') {
                queue.add(i);
                visited.set(i, ++islands);
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    if (u == b) found = true;
                    int v;
                    if ((v = u-n) >= 0 && visited.get(v) == -1 && map.get(v/n).charAt(v%n) == '0') {
                        queue.add(v);
                        visited.set(v, islands);
                    }
                    if ((v = u+n) < ns && visited.get(v) == -1 && map.get(v/n).charAt(v%n) == '0') {
                        queue.add(v);
                        visited.set(v, islands);
                    }
                    if ((v = u+1)%n != 0 && visited.get(v) == -1 && map.get(v/n).charAt(v%n) == '0') {
                        queue.add(v);
                        visited.set(v, islands);
                    }
                    if (((v = u-1)%n != n-1 && v != -1) && visited.get(v) == -1 && map.get(v/n).charAt(v%n) == '0') {
                        queue.add(v);
                        visited.set(v, islands);
                    }
                }
            }
            i = (i + 1) % ns;
            if (i == a) break;
        }

        List<Integer> si = new ArrayList<>(ns);
        List<Integer> fi = new ArrayList<>(ns);
        for (int j=0; j<ns; j++) {
            if (visited.get(j) == 0) si.add(j);
            else if (visited.get(j) == islands) fi.add(j);
        }
        if (islands == 0) return 0;
        int answer = Integer.MAX_VALUE;
        for (int k: si) {
            for (int j: fi) {
                int w = k/n, x = k%n;
                int y = j/n, z = j%n;
                int dist = (w - y)*(w - y) + (x - z)*(x - z);
                if (dist < answer) answer = dist;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int d = sc.nextInt() - 1;
        List<String> map = new ArrayList<>(n);
        for (int i=0; i<n; i++) {
            map.add(sc.next());
        }
        System.out.println(solve(n, a*n + b, c*n + d, map));
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
