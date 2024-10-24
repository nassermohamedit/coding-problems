import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MaximizeMex {


  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    int a;
    int[] count = new int[200007];
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      for (int i = 0; i <= n; i++) {
        count[i] = 0;
      }
      for (int i = 0; i < n; ++i) {
        a = sc.nextInt();
        if (a < n) count[a]++;
      }
      for (int i = 0; i < n; ++i) {
        if (count[i] > 1) {
          int s = i + x;
          while (count[i] > 1 && s < n) {
            count[s]++;
            count[i]--;
            s += x;
          }
        }
        else if (count[i] == 0){
          break;
        }
      }
      for (int i = 0; i <= n; i++) {
        if (count[i] == 0) {
          out.write(i + "\n");
          break;
        }
      }
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
        while (st == null || !st.hasMoreTokens() ) {
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

