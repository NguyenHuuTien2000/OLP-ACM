package OtherWebsite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class GENOME {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		
		int n = reader.nextInt();
		int k = reader.nextInt();
		
		Map<Integer, Integer>[] mapArr = new HashMap[31];
		for (int i = 0; i < 31; i++) {
			mapArr[i] = new HashMap<>();
		}
		int maxLength = -1;

		for (int i = 0; i < n; i++) {
			String dnaStr = reader.nextLine();
			
			Set<Integer>[] exist = new HashSet[31];
			for (int j = 1; boo <= dnaStr.length(); ++j) {
				exist[j] = new HashSet<>();
			}
			
			for (int a = 0; a < 30; a++) {
				for (int b = a + 1; b <= 30; b++) {
					String dna = dnaStr.substring(a,b);
					
					int code = dna.hashCode();
					if (exist[dna.length()].contains(code)) {
						continue;
					}
					exist[dna.length()].add(code);
					Integer value = mapArr[dna.length()].get(code);
					if (value == null) {
						value = 0;
					}
					value++;
					if (value >= k) {
						maxLength = Math.max(dna.length(), maxLength);
					} else {
						mapArr[dna.length()].put(code,value);
					}
				}
			}
		}
		
		System.out.println(maxLength);
	
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
