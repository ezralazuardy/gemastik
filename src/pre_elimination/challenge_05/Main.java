package pre_elimination.challenge_05;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);

        final String[] adhi = in.nextLine().trim().split(" ");
        final String[] vijay = in.nextLine().trim().split(" ");

        in.close();

        int[] daduA = new int[adhi.length];
        int maxA = Integer.MIN_VALUE;
        for (int i = 0; i < adhi.length; i++) {
            daduA[i] = Integer.parseInt(adhi[i]);
            if (maxA < daduA[i]) maxA = daduA[i];
        }

        int[] daduB = new int[vijay.length];
        int maxB = Integer.MIN_VALUE;
        for (int i = 0; i < vijay.length; i++) {
            daduB[i] = Integer.parseInt(vijay[i]);
            if (maxB < daduB[i]) maxB = daduB[i];
        }

        final long startTime = System.nanoTime();

        int[] cntA = new int[maxA + 1];
        int[] cntB = new int[maxB + 1];
        for (int i = 0; i < adhi.length; i++) {
            cntA[daduA[i]]++;
            cntB[daduB[i]]++;
        }

        // count probability
        double[] probA = new double[maxA + 1];
        double[] probB = new double[maxB + 1];
        for (int i = 0; i < probA.length; i++) {
            probA[i] = 1.0 * cntA[i] / adhi.length;
        }
        for (int i = 0; i < probB.length; i++) {
            probB[i] = 1.0 * cntB[i] / vijay.length;
        }

        // count menang Adhi
        double menangAdhi = 0.0;
        for (int i = 0; i < probA.length; i++) {
            for (int j = 0; j < probB.length; j++) {
                if (probA[i] != 0 && probB[j] != 0 && i > j) {
                    menangAdhi += probA[i] * probB[j];
                }
            }
        }

        // count menang Vijay
        double menangVijay = 0.0;
        for (int i = 0; i < probB.length; i++) {
            for (int j = 0; j < probA.length; j++) {
                if (probB[i] != 0 && probA[j] != 0 && i > j) {
                    menangVijay += probB[i] * probA[j];
                }
            }
        }

        if (menangVijay == menangAdhi) {
            System.out.println("Imbang");
        } else if (menangAdhi > menangVijay) {
            System.out.format("Adhi menang dengan peluang %.2f%n", menangAdhi);
        } else {
            System.out.format("Vijay menang dengan peluang %.2f%n", menangVijay);
        }

        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }
}
