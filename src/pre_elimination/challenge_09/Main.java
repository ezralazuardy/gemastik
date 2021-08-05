package pre_elimination.challenge_09;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.Scanner;

/**
 * <h1>Bilangan Mandiri</h1>
 * <small>
 * Time limit: 3 second / test case<br/>
 * Memory limit: 700 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Gema dan Astik sangat suka sekali bermain angka. Dalam permainan ini Gema akan memberikan
 * dua bilangan bulat 𝐴 dan 𝐵 kepada Astik untuk kemudian mencari banyaknya bilangan bulat antara
 * 2 sampai 𝐵 yang merupakan Bilangan Mandiri. Bilangan Mandiri dari (𝐴,𝐵) didefinisikan sebagai
 * bilangan bulat 𝑏𝑖 (2 ≤ 𝑏𝑖 ≤ 𝐵) yang bukan merupakan kelipatan dari salah satu atau lebih
 * bilangan bulat 𝑎𝑖 (2 ≤ 𝑎𝑖 ≤ 𝐴). Sebagai contoh, jika diketahui 𝐴 = 2 dan 𝐵 = 8, maka bilangan
 * bulat antara 2 sampai 8 yang merupakan kelipatan dari 2 adalah 2, 4, 6, dan 8. Sehingga yang
 * merupakan Bilangan Mandiri dari (2, 8) adalah 3, 5, dan 7 yang ada sebanyak 3.
 * </p>
 * <p>
 * Tugas Anda adalah membantu Astik dalam mencari Bilangan Mandiri dari rentang yang diberikan
 * oleh Gema.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Baris pertama berisi sebuah bilangan bulat positif 𝑁 (1 ≤ 𝑁 ≤ 100) yang menunjukkan
 * banyaknya pasangan 𝐴 dan 𝐵 yang disebutkan oleh Gema. 𝑁 baris berikutnya masing-masing
 * berisi dua bilangan bulat 𝐴 dan 𝐵 yang dipisahkan oleh spasi dengan ketentuan 2 ≤ 𝐴 ≤ 130
 * dan 2 ≤ 𝐵 ≤ 10^15. Untuk setiap pasangan (𝐴,𝐵), keluarkan banyaknya Bilangan Mandiri.
 * </p>
 * <p>
 * <table style="width: 100%;">
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 2<br/>
 * 2 8<br/>
 * 3 20<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 3<br/>
 * 6<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <h2>Solution</h2>
 * Worst case time & space complexity:<code><b> ?</b></code>
 * </p>
 * <p>
 * <h3>Author</h3>
 * Ezra Lazuardy<br/>
 * <a href="mailto:ezralucio@gmail.com">ezralucio@gmail.com</a><br/>
 * <a href="https://ezralazuardy.com">https://ezralazuardy.com</a>
 * </p>
 */

public class Main {

    /**
     * Main method
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final int n = Math.min(Math.max(Integer.parseInt(in.nextLine()), 1), 100);
        final long[][] pair = new long[n][2];
        for (int i = 0; i < n; i++) {
            pair[i] = new long[2];
            pair[i][0] = Math.min(Math.max(in.nextLong(), 2), 130);
            pair[i][1] = Math.min(Math.max(in.nextLong(), 2), (long) Math.pow(10, 15));
        }

        in.close();

        final long startTime = System.nanoTime();

        final int[] result = new int[n];

        for (int i = 0; i < pair.length; i++) {

            // if a & b is same, return 0 as result
            if (pair[i][0] == pair[i][1]) {
                result[i] = isPrime(pair[i][0]) ? 1 : 0;
                continue;
            }

            // count prime number beetween a & b (exclusive)
            int c = 0;
            for (long j = pair[i][0] + 1; j < pair[i][1]; j++)
                if (isPrime(j)) c++;
            result[i] = c;
        }

        for (int entry : result) System.out.println(entry);

        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }

    /**
     * Check if n is prime or not
     *
     * @param n int
     * @return boolean
     */
    private static boolean isPrime(long n) {
        if (n <= 2) return false;
        boolean prime = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
