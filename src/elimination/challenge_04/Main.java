package elimination.challenge_04;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.Scanner;

public class Main {

    /**
     * Main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.close();

        // record the execution start time
        long startTime = System.nanoTime();

        // print the runtime information
        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }
}
