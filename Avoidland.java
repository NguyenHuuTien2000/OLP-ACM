package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Avoidland {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();

        int[] vertical = new int[n];
        int[] horizontal = new int[n];

        for (int i = 0; i < n; i++) {
            vertical[reader.nextInt() - 1]++;
            horizontal[reader.nextInt() - 1]++;
        }
        System.out.println(calculate(vertical) + calculate(horizontal));
    }

    static long calculate(int[] arr) {
        long sum = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            sum += Math.abs(i + 1 - temp);
        }
        return sum;
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
