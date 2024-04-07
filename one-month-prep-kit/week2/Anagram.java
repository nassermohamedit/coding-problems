import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * statement: https://www.hackerrank.com/challenges/anagram/problem
     */

    public static int anagram(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                    return -1;
            }
            int[] multiset = new int[26];
            for (int i = 0; i < n/2; ++i) {
                    ++multiset[s.charAt(i) - 'a'];
            }
            for (int i = n/2; i < n; ++i) {
                    --multiset[s.charAt(i) - 'a'];
            }
            int ans = 0;
            for (int m: multiset) {
                    ans += Math.abs(m);
            }
            return ans/2;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

