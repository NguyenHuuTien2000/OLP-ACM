package Contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RationalRatio {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        String decimalStr = reader.next();
        int repeats = reader.nextInt();

        int decimalPlace = decimalStr.indexOf('.');
        long beforeDec = Long.parseLong(decimalStr.substring(0,decimalPlace));
        int nonRepeat = decimalStr.length() - decimalPlace - repeats - 1;

        long denominator = (long) ((Math.pow(10, decimalStr.length() - decimalPlace - 1)) - Math.pow(10, nonRepeat));

        long numerator = Long.parseLong(decimalStr.substring((decimalPlace + 1), (decimalPlace + repeats + nonRepeat + 1)));

        if (nonRepeat != 0) {
            numerator -= Long.parseLong(decimalStr.substring((decimalPlace + 1), (decimalPlace + nonRepeat + 1)));
        }

        numerator += (denominator * beforeDec);

        long gcd = findGDC(denominator, numerator);

        System.out.println(numerator/gcd + "/" + denominator/gcd);
    }

    static long findGDC(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return findGDC(n2, n1 % n2);
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
