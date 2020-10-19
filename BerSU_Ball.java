package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BerSU_Ball {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		
		int n = reader.nextInt();
		List<Integer> boys = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			boys.add(reader.nextInt());
		}
		
		int m = reader.nextInt();
		List<Integer> girls = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			girls.add(reader.nextInt());
		}
		
		boys.sort(Integer::compareTo);
		girls.sort(Integer::compareTo);
		
		int pairs = 0;
		
		for (int i = 0; i < boys.size();i++) {
			for (int j = 0; j < girls.size(); j++) {
				if (Math.abs(boys.get(i) - girls.get(j)) <= 1) {
					pairs++;
					boys.remove(i);
					girls.remove(j);
					j--;
				}
			}
		}
		System.out.println(pairs);
		
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
