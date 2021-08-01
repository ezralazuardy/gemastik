package elimination.challenge_05;

import helper.MemoryUsageHelper;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * <h1>Baris Pangkat</h1>
 * <small>
 * Time limit: 1 second / test case<br/>
 * Memory limit: 256 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Diberikan sebuah barisan bilangan bulat 𝑎1, 𝑎2, … , 𝑎𝑛, tentukan nilai dari
 * </p>
 * <p>
 * 𝐴 = pow(pow(𝑎1, 𝑎2), ... 𝑎𝑛) mod 100 000 037
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan dimulai dengan sebuah baris berisi sebuah bilangan 𝑛 yang menyatakan panjang barisan,
 * kemudian diikuti dengan 𝑛 buah bilangan bulat yang menyatakan barisan bulat 𝑎1, 𝑎2, … , 𝑎𝑛.
 * Keluaran merupakan sebuah baris berisi satu buah bilangan yaitu nilai 𝐴.
 * Nilai 𝑛 memenuhi 1 ≤ 𝑛 ≤ 10 000 dan nilai 𝑎𝑖 memenuhi 1 ≤ 𝑎𝑖 ≤ 100 000 untuk setiap
 * 1 ≤ 𝑖 ≤ 𝑛.
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
 * 3<br/>
 * 3<br/>
 * 2<br/>
 * 3<br/>
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
 * 6561<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
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
 * 5<br/>
 * 5<br/>
 * 4<br/>
 * 3<br/>
 * 2<br/>
 * 1<br/>
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
 * 55456697<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <h2>Solution</h2>
 * Worst case time & space complexity:<code><b> O(n)</b></code>
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

        final int[] a = new int[Integer.parseInt(in.nextLine())];

        // time & space complexity: O(n)
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
