// https://codeforces.com/problemset/problem/1917/A

import java.util.Scanner;

public class LeastProduct {

    static int t;
    static int n;
    static int[] a = new int[107];

    static void solve() {
        int sign = 1;
        for (int i=0; i<n; ++i) {
            if (a[i] == 0) {
                System.out.println(0);
                return;
            }
            if (a[i] < 0) sign *= -1;
        }
        if (sign > 0)
            System.out.println("1\n1 0");
        else
            System.out.println(0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        t = sc.nextInt();
        for (int i=0; i<t; ++i) {
            n = sc.nextInt();
            for (int j=0; j<n; ++j) {
                a[j] = sc.nextInt();
            }
            solve();
        }
        sc.close();
    }
}