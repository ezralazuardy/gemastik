package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <h3>Reader class</h3>
 * Library class for faster and simple input processing (Scanner alternative).
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class Reader {

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
