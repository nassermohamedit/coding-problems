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
     * ugly statement: https://www.hackerrank.com/challenges/one-month-preparation-kit-dynamic-array
     */

    public static List<Integer> uglyDynamicArray(int n, List<List<Integer>> uglyQueries) {
            List<List<Integer>> uglyArr = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                    uglyArr.add(new ArrayList<>());
            }
            List<Integer> uglyAnswer = new ArrayList<>();
            int uglyLastAnswer = 0;
            for (List<Integer> uglyQuery: uglyQueries) {
                    int t = uglyQuery.get(0);
                    int x = uglyQuery.get(1);
                    int y = uglyQuery.get(2);
                    if (t == 1) {
                            uglyArr.get((x^uglyLastAnswer)%n).add(y);
                    } else {
                            int i = (x^uglyLastAnswer)%n;
                            uglyLastAnswer = uglyArr.get(i).get(y%uglyArr.get(i).size());
                            uglyAnswer.add(uglyLastAnswer);
                    }
            }
            return uglyAnswer;
    }
}

public class UglyDynamicArrayProblemInTheUglyPlatform {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.uglyDynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

