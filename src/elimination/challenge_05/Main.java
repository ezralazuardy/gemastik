package elimination.challenge_05;

import helper.MemoryUsageHelper;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    /**
     * Main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int[] a = new int[Integer.parseInt(in.nextLine())];

        for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(in.nextLine());

        in.close();

        System.out.println(solve(a, 0, BigInteger.valueOf(a[0])));

        MemoryUsageHelper.printMemoryUsage();
    }

    private static BigInteger solve(int[] a, int i, BigInteger result) {
        if (++i < a.length) result = solve(a, i, result.pow(a[i]));
        return result.mod(BigInteger.valueOf(100000037));
    }
}
