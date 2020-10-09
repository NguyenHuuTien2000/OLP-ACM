package OtherWebsite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MTRAMDEN {
    public static void main(String[] args) {
         InputReader reader = new InputReader(System.in);
         int t = reader.nextInt();
         StringBuilder res = new StringBuilder();

         while (t-- > 0) {
             long k = reader.nextLong();
             long m = - 1;
             long n;
             for (long i = (long) Math.sqrt(k); i >= 1 ; i--) {
                 n = (2*k - 1 - i)/(2*i + 1);
                 if (n*i + (n + 1)*(i + 1) == 2*k) {
                     m = i;
                     res.append(Math.min(i,n)).append(" ").append(Math.max(i,n)).append("\n");
                     break;
                 }
             }
             if (m == -1) {
                 res.append(-1 + " " + -1).append("\n");
             }
         }
        System.out.println(res);
    }
    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public boolean hasNext() throws IOException {
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                return true;
            }
            token = reader.readLine();
            return (token != null && token.length() > 0);
        }

        public String nextLine() {
            try {
                token = reader.readLine();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            return token;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (token != null) {
                        tokenizer = new StringTokenizer(token);
                        token = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
