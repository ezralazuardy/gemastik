package elimination.challenge_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        final Reader in = new Reader();

        int n = Math.min(Math.max(in.nextInt(), 1), 1000), x = Math.min(Math.max(in.nextInt(), 1), 99999), min = Integer.MAX_VALUE;

        final int[] couponts = new int[n];

        for (int i = 0; i < couponts.length; i++) {
            couponts[i] = Math.min(Math.max(in.nextInt(), 1), 99999);
            min = Math.min(Math.abs(x - couponts[i]), min);
        }

        Arrays.sort(couponts);

        for (int coupont : couponts)
            if (Math.abs(x - coupont) == min) System.out.println(coupont);

        in.close();
    }

    public static class Reader {

        private final BufferedReader br;
        private StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() throws NumberFormatException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws NumberFormatException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws NumberFormatException {
            return Double.parseDouble(next());
        }

        public void close() {
            try {
                if (br == null) return;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
