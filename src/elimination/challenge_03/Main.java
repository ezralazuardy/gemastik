package elimination.challenge_03;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        while (n-- > 0) {

            String[] data = in.nextLine().trim().split(" ");
            if (data.length < 3) throw new IllegalStateException("Input must be P Q and M");

            // record the execution start time
            long startTime = System.nanoTime();

            int m = Integer.parseInt(data[2]);
            int p = (int) Math.floor(Integer.parseInt(data[0]) / Math.pow(2, m % 2 == 0 ? m / 2 : (m + 1) / 2));
            int q = (int) Math.floor(Integer.parseInt(data[1]) / Math.pow(2, m % 2 == 0 ? m / 2 : (m - 1) / 2));
            if (q > p) {
                int temp = p;
                p = q;
                q = temp;
            }
            System.out.format("%n%d %d", p, q);

            // print the runtime information
            ExecutionTimeHelper.printExecutionTime(startTime);
            MemoryUsageHelper.printMemoryUsage();
            System.out.println();
        }

        in.close();
    }
}
