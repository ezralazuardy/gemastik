package helper;

public class MemoryUsageHelper {

    public static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        System.out.format("%nMemory usage: %.1f MB%n", (double) (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
