package CodeForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumOfApartment {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);

		StringBuilder res = new StringBuilder();
		int t = reader.nextInt();
		while (t-- > 0) {
			int n = reader.nextInt();
			
			int type3 = calcApartment(7, n);
			int type2 = calcApartment(5, n -= 7*type3);
			int type1 = calcApartment(3, n -= 5*type2);
			
			if (type1+type2+type3 == 0) {
				res.append("-1");
			} else {
				res.append(type1).append(" ").
				append(type2).append(" ").append(type3);
			}
			res.append("\n");

		}

		System.out.println(res);

	}
	
	static int calcApartment(int type, int windows) {
		for (int i = windows/type; i >= 1; i--) {
			if ((windows - type * i) < 3 && (windows - type * i) > 0) {
				continue;
			}
			if ((windows - type * i) % 2 == 1 || (windows - type * i) % (type -2) == 0) {
				return i;
			}
		}
		return 0;
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
