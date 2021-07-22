package helper;

/**
 * <h3>MemoryUsageHelper class</h3>
 * Helper class to print the program memory usage information
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */
public class MemoryUsageHelper {

    private static final Runtime runtime;

    static {
        runtime = Runtime.getRuntime();
    }

    /**
     * Print the execution memory usage in Megabytes (MB)
     */
    public static void printMemoryUsage() {
        System.out.format("%nMemory usage: %.1f MB%n", (double) (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
        runtime.gc();
    }
}
