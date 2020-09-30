package VNOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class KDelete {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();


        StringBuilder primeStr = new StringBuilder("2");

        int num = 3;
        boolean isPrime = true;
        for (int i = 2; i <= n;) {
            for (int j = 2; j*j <= num; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeStr.append(num);
                i++;
            }
            isPrime = true;
            num++;
        }

        StringBuilder res = new StringBuilder();

        char[] primeChar = primeStr.toString().toCharArray();
        int length = primeChar.length;

        Deque<Integer> indexQueue = new LinkedList<>();
        int last = 0;
        int currentK = k;
        for (int i = 0, j = 0; i < length && j < length - k; ++i) {

            while (!indexQueue.isEmpty() && primeChar[indexQueue.peekLast()] < primeChar[i]) {
                indexQueue.pollLast();
            }
            indexQueue.add(i);

            if (i == currentK) {
                while (!indexQueue.isEmpty() && indexQueue.peek() < last) {
                    indexQueue.pollFirst();
                }

                res.append(primeChar[indexQueue.peek()]);
                j++;
                last = indexQueue.peek() + 1;
                currentK = Math.min(k + j, length - 1);
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
