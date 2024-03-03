// https://codeforces.com/contest/1864/problem/A

import java.util.Scanner;

public class Test {

    public static void solver(int x, int y, int n) {
        int[] answer = new int[n];
        int k = 0;
        boolean no = false;
        for (int i=n-1; i > 0; i--) {
            if (y - k < x) {
                no = true;
                break;
            }
            answer[i] = y - k;
            y = y - k;
            k++;
        }
        if (no || y - k < x) System.out.println("-1");
        else {
            answer[0] = x;
            for (int i=0; i<n; i++)
                System.out.print(answer[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        // Loop for each test case
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int n = scanner.nextInt();
            Test.solver(x, y, n);
        }

        scanner.close();
    }
}
