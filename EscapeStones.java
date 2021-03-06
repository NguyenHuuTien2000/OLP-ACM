package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EscapeStones {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		
		String escapeMoves = reader.nextLine();
		StringBuilder res = new StringBuilder();
		
		int length = escapeMoves.length();
		int left = 0;
		int right = length - 1 ;
		int[] positions = new int[length];
		
		for (int i = 0; i < length; i++) {
			if (escapeMoves.charAt(i) == 'l') {
				positions[right--] = i + 1;
			} else {
				positions[left++] = i + 1;
			}
		}
		for (int i : positions) {
			res.append(i).append("\n");
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
