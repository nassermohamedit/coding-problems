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
     * statement: https://www.hackerrank.com/challenges/palindrome-index/problem
     */

    public static int palindromeIndex(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right && s.charAt(left) == s.charAt(right)) {
                    ++left;
                    --right;
            }
            if (left >= right) {
                    return -1;
            }
            int l = left;
            int r = right;
            --right;
            while (left < right && s.charAt(left) == s.charAt(right)) {
                    ++left;
                    --right;
            }
            if (left >= right) {
                    return r;
            }
            left = l;
            right = r;
            ++left;
            while (left < right && s.charAt(left) == s.charAt(right)) {
                    ++left;
                    --right;
            }
            if (left >= right) {
                    return l;
            }
            return -1;
    }

}

public class PalindromIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

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

