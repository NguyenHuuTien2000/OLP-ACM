package VNOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Polycarp {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        StringBuilder res = new StringBuilder();

        int t;
        int maxHeight = 0;
        int maxWidth = 0;
        while (n-- > 0) {
            String query = reader.next();
            int height = reader.nextInt();
            int width = reader.nextInt();
            if (height > width) {
                t = height;
                height = width;
                width = t;
            }
            if (query.equals("+")) {
                maxHeight = Math.max(height, maxHeight);
                maxWidth = Math.max(width, maxWidth);
            } else {
                if (height >= maxHeight && width >= maxWidth) {
                    res.append("YES").append("\n");
                } else {
                    res.append("NO").append("\n");
                }
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
