import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeaningMean {

  public static void main(String[] args) throws InterruptedException, IOException {

    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int[] a = new int[57];
    while (t-- > 0) {
      int n = sc.nextInt();
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
      }
      Arrays.sort(a, 0, n);
      for (int i = 1; i < n; ++i) {
        a[i] = (a[i] + a[i - 1]) / 2;
      }
      out.write(a[n - 1] + "\n");
    }
    out.flush();
  }
}

class Scanner {

  private final BufferedReader br;
  private StringTokenizer st;

  public Scanner(InputStream in) {
    this.br = new BufferedReader(new InputStreamReader(in));
  }

  public String next() {
    while (st == null || !st.hasMoreTokens()) {
      try {
        st = new StringTokenizer(this.br.readLine());
      } catch (IOException e) {
        throw new RuntimeException();
      }
    }
    return st.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }
}
