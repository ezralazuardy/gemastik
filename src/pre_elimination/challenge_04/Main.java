package pre_elimination.challenge_04;

import java.util.Scanner;

public class Main {

    /**
     * Main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int min = in.nextInt(), max = in.nextInt(),
                a = in.nextInt(), b = in.nextInt(), c = in.nextInt();

        in.close();

        int ca = 0, cb = 0, cc = 0;

        for (int i = min; i <= max; i++) {
            if (i % a == 0 && i % b != 0 && i % c != 0) ca++;
            else if (i % a != 0 && i % b == 0 && i % c != 0) cb++;
            else if (i % a != 0 && i % b != 0 && i % c == 0) cc++;
        }

        System.out.println(ca + cb + cc);
    }
}
