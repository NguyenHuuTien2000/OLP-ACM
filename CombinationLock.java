package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinationLock {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int startPos = reader.nextInt();
        int combA = reader.nextInt();
        int combB = reader.nextInt();
        int combC = reader.nextInt();

        StringBuilder res = new StringBuilder();

        while (startPos + combA + combB + combC != 0) {
            int currPos = 1080;

            currPos += ((startPos + 40 - combA)%40)*9;
            currPos += ((combB + 40 - combA)%40)*9;
            currPos += ((combB + 40 - combC)%40)*9;

            res.append(currPos).append("\n");

            startPos = reader.nextInt();
            combA = reader.nextInt();
            combB = reader.nextInt();
            combC = reader.nextInt();

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
