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
     * statement: https://www.hackerrank.com/challenges/between-two-sets/problem
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
            int ans = 0;
            for (int i = 1; i <= 100; ++i) {
                    boolean factorOfAll = true;
                    for (int x: b) {
                            if (x % i != 0) {
                                    factorOfAll = false;
                                    break;
                            }
                    }
                    if (factorOfAll) {
                            boolean multipleOfAll = true;
                            for (int x: a) {
                                    if (i % x != 0) {
                                            multipleOfAll = false;
                                            break;
                                    }
                            }
                            if (multipleOfAll) {
                                    ++ans;
                            }
                    }
            }
            return ans;
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

