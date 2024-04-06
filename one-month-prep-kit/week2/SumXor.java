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
     * tags: bit manipulation
     * statement: https://codeforces.com/contest/1951/problem/A
     */

    public static long sumXor(long n) {
            
            long b = 1;
            int c = 0;
            while (b <= n) {
                    if ((n & b) == 0) ++c;
                    b <<= 1;
            }
            return (long) Math.pow(2, c);
    }

}

public class SamXor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

