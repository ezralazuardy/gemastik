package helper;

public class ExecutionTimeHelper {

    public static void printExecutionTime(long startTime) {
        System.out.format("%nExecution time: %d ms", (System.nanoTime() - startTime) / 1000000);
    }
}
