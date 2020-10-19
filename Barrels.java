package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Barrels {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		
		int t = reader.nextInt();
		List<Long> barrels = new ArrayList<>();
		while(t-- > 0) {
			int n = reader.nextInt();
			int k = reader.nextInt();
			
			for (int i = 0; i < n; i++) {
				barrels.add(reader.nextLong()); 
			}
			
			barrels.sort(Long::compareTo);
			
			int last = n - 2;
			long maxDiff = barrels.get(n - 1);
			
			for (int i = 0; i < k; i++) {
				maxDiff += barrels.get(last--);
			}
			barrels.clear();
			System.out.println(maxDiff);
		}

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
