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
     * statement: https://www.hackerrank.com/challenges/one-month-preparation-kit-caesar-cipher-1
     */

    public static String caesarCipher(String s, int k) {
        StringBuilder encrypted = new StringBuilder(s.length());
        for (char c: s.toCharArray()) {
            int e;
            if (c >= 'a' && c <= 'z' ) {
                e = 'a' + (c - 'a' + k)%26;
            } else if (c >= 'A' && c <= 'Z') {
                e = 'A' + (c - 'A' + k)%26;
            } else {
                e = c;
            }
            encrypted.append((char) e);
        }
        return encrypted.toString();
    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

