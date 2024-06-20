import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class AliceAndBooks {
    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt();
        int[] a = new int[107];
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; ++i) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
            int ans = a[n - 1] + max; 
            out.write(ans + "\n");
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
