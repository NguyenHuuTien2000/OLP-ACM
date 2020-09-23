package VNOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CarRepair {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        StringBuilder res = new StringBuilder();

        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n*2; i++) {
            if (i >= n) {
                carList.get(i - n).addRepair(reader.nextInt());
            } else {
                carList.add(new Car(i + 1, reader.nextInt()));
            }
        }

        carList.sort(Comparator.comparingDouble(o -> o.ratio));

        long minFee = 0;
        long repairDays = 0;
        for (int i = 0; i < n; i++) {
            repairDays += carList.get(i).repairTime;
            minFee += repairDays*carList.get(i).fee;
        }
        res.append(minFee).append("\n");
        for (Car car : carList) {
            res.append(car.id).append(" ");
        }
        System.out.println(res);
    }

    static class Car {
        public int id;
        public int fee;
        public int repairTime;
        public double ratio;

        public Car(int id, int fee) {
            this.id = id;
            this.fee = fee;
        }

        public void addRepair(int repairTime) {
            this.repairTime = repairTime;
            this.ratio = (double) this.repairTime/ this.fee;
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
