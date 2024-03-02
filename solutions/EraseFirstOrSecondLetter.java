//problem: https://codeforces.com/problemset/problem/1917/B

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EraseFirstOrSecondLetter {

    static int t;
    static String str;
    static int n;
    /*
    static int solveCase(int n, String str) {
        Set<Character> chars = new HashSet<>();
        int answer = 0;
        for (int i=0; i<n; ++i) {
            chars.add(str.charAt(i));
            answer += chars.size();
        }
        return answer;
    }
    */

    static int solveCase(int n, String str) {
        Set<Character> chars = new HashSet<>();
        int answer = 0;
        for (int i=0; i<n; ++i) {
            char c = str.charAt(i);
            if (!chars.contains(c)) {
                answer += n - i;
                chars.add(c);
            }
            // minor optimization: if chars.size() == 26 -> return answer
            // worst case complexity: unchanged
        }
        return answer;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int answer;

        t = Integer.valueOf(sc.nextLine());
        for (int i=0; i<t; i++) {
            n = Integer.valueOf(sc.nextLine());
            str =  sc.nextLine();
            answer = solveCase(n, str);
            System.out.println(answer);
        }
        sc.close();
    }
}
