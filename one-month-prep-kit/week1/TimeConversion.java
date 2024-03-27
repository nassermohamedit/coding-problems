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
     * statement: https://www.hackerrank.com/challenges/one-month-preparation-kit-time-conversion
     */

    public static String timeConversion(String s) {
        boolean am = s.substring(8).equals("AM");
        String hour = s.substring(0, 2);
        String ms = s.substring(2, 8);
        String ans;
        if (am) {
            if (hour.equals("12")) ans = "00" + ms;
            else ans = s.substring(0, 8);
        } else {
            if (hour.equals("12")) ans = s.substring(0, 8);
            else ans = (Integer.parseInt(hour) + 12) + ms;
        }
        return ans;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

