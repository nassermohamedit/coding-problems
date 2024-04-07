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
     * statement: https://www.hackerrank.com/challenges/one-month-preparation-kit-counter-game
     */

    public static String counterGame(long n) {
            if (n == 1) return "Richard";
            int turn = 0;
            String[] ans = {"Louise", "Richard"};
            while (n > 1) {
                    int p = 0;
                    long k = 1;
                    while (k < n) {
                            k <<= 1;
                            ++p;
                    }
                    if (k == n) {
                        return ans[(turn + p%2 + 1)%2];
                    }
                    n -= k/2;
                    turn = (turn + 1)%2;
            }
            return ans[(turn + 1)%2];
    }

}

public class CounterGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.counterGame(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

