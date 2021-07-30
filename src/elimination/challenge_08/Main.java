package elimination.challenge_08;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = in.nextInt();
        final int m = in.nextInt();
        final int q = in.nextInt();
        final int[][] a = new int[n][m];
        final int[] result = new int[q];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < q; i++) {
            final int x1 = in.nextInt() - 1, y1 = in.nextInt() - 1, x2 = in.nextInt() - 1, y2 = in.nextInt() - 1;
            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    sum += a[j][k];
                }
            }
            result[i] = sum;
        }

        for (int entry : result) {
            System.out.println(entry);
        }

        in.close();
    }
}
