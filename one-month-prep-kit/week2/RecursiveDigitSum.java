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
     * statement: https://www.hackerrank.com/challenges/one-month-preparation-kit-recursive-digit-sum
     */

    public static int superDigit(String n, int k) {
            long sum = 0;
            for (char d: n.toCharArray()) {
                    sum += Integer.valueOf("" + d);
            }
            sum *= k;
            n = "" + sum;
            while (n.length() > 1) {
                    sum = 0;
                    for (char d: n.toCharArray()) {
                        sum += Integer.valueOf("" + d);
                    }
                    n = "" + sum;
            }
            return Integer.valueOf(n);
    }

}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

