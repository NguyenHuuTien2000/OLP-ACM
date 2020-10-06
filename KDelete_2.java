package VNOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KDelete_2 {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();

        Queue<Integer>[] indexTable = new LinkedList[10];

        for (int i = 0; i < 10; i++) {
            indexTable[i] = new LinkedList<>();
        }

        int currIndex = 0;
        int num = 2;
        boolean isPrime = true;
        for (int i = 1; i <= n; ) {
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                String primeStr = "" + num;
                for (int j = 0; j < primeStr.length(); j++) {
                    indexTable[primeStr.charAt(j) - '0'].add(currIndex);
                    currIndex++;
                }
                i++;
            }

            isPrime = true;
            num++;
        }

        StringBuilder res = new StringBuilder();

        int maxIndex = 0;
        int length = currIndex;
        currIndex = k;

        while (currIndex < length) {

            for (int j = 9; j >= 0; j--) {
                boolean check = true;

                while (!indexTable[j].isEmpty() && indexTable[j].element() <= currIndex) {
                    int index = indexTable[j].remove();
                    if (index >= maxIndex) {
                        maxIndex = index;
                        res.append(j);
                        currIndex++;
                        check = false;
                        break;
                    }
                }

                if (!check) {
                    break;
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
            } catch (IOException e) {
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
