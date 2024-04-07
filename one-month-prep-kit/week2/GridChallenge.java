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
     * statement: https://www.hackerrank.com/challenges/one-month-preparation-kit-grid-challenge
     */

    public static String gridChallenge(List<String> grid) {
        int n = grid.size();
        int m = grid.get(0).length();
        for (int i = 0; i < n; ++i) {
                char[] chars = grid.get(i).toCharArray();
                Arrays.sort(chars);
                grid.set(i, new String(chars));
        }
        for (int i = 0; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                        if (grid.get(j).charAt(i) < grid.get(j - 1).charAt(i)) {
                                return "NO";
                        }
                }
        }
        return "YES";
    }
}

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

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

