package elimination.challenge_06;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = Integer.parseInt(in.nextLine());

        final String[] data = in.nextLine().trim().split(" ");

        in.close();

        final long startTime = System.nanoTime();

        final ArrayList<Integer> a = new ArrayList<>();

        for (String entry : data) a.add(Integer.valueOf(entry));

        a.sort(Collections.reverseOrder());

        System.out.println(giveaway(a, n, 0));

        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }

    private static int giveaway(final ArrayList<Integer> a, int n, int m) {
        if (m > a.size()) return -1;
        if (n >= 0 && m == a.size()) return 1;
        if (n < 0) return 0;
        int w = 0;
        for (int i = a.get(m); i <= n; i++) {
            if (m > 0) w += giveaway(a, n - i, m + 1); // orang kedua dst.
            else w = Math.max(w, giveaway(a, n - i, m + 1)); // orang pertama
        }
        return w;
    }
}
