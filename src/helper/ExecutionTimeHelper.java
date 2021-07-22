package helper;

/**
 * <h3>ExecutionTimeHelper class</h3>
 * Helper class to print the program execution time information
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class ExecutionTimeHelper {

    /**
     * Print the execution time in millisecond
     *
     * @param startTime long
     */
    public static void printExecutionTime(long startTime) {
        System.out.format("%nExecution time: %d ms", (System.nanoTime() - startTime) / 1000000);
    }
}
