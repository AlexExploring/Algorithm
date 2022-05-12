import java.io.*;
import java.util.StringTokenizer;

public class java高效输入输出 {
    public static void main(String[] args) throws IOException {
        while (true){
            InputReader scan = new InputReader(System.in);
            double v = scan.nextDouble();
            System.out.println(v);
        }
    }

    static class InputReader{
        private final static int BUF_SZ = 65536;
        BufferedReader in;
        StringTokenizer tokenizer;
        public InputReader(InputStream in) {
            super();
            this.in = new BufferedReader(new InputStreamReader(in),BUF_SZ);
            tokenizer = new StringTokenizer("");
        }
        private String next() {
            while (!tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    /**
     * 输出比较简单的话直接使用PrintWriter
     * public static InputReader in = new InputReader(System.in);
     * public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
     */
}
