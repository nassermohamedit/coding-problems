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
     * https://www.hackerrank.com/challenges/one-month-preparation-kit-pangrams
     */

    public static String pangrams(String s) {
        int[] alpha = new int['z' - 'a' + 1];
        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                alpha[c - 'a'] = 1;
            else if (c >= 'A' && c <= 'Z')
                alpha[c - 'A'] = 1;
        }
        for (int v: alpha) {
            if (v == 0) return "not pangram";
        }
        return "pangram";
    }
}

public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

