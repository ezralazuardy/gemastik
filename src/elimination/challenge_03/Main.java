package elimination.challenge_03;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.Scanner;

/**
 * <h1>Lipat Kertas Gambar</h1>
 * <small>
 * Time limit: 1 second / test case<br/>
 * Memory limit: 256 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Inneo gemar merwarnai pada selembar kertas gambar berbentuk persegi Panjang. Namun di waktu
 * luangnya, terkadang tanpa disadari dia juga sering melipat kertas gambar yang sudah diwarnainya.
 * Dia selalu melipat kertas pada sisi yang lebih panjang, misalnya jika dia mempunyai kertas gambar
 * berukuran 120 × 80, maka dia akan melipat sisi dengan panjang 120, sehingga ukuran kertasnya
 * menjadi 60×80. Pada berikutnya dia kembali melipat kertas pada sisi dengan panjang 80, sehingga
 * sekarang ukuran kertasnya menjadi 60 × 40.
 * </p>
 * <p>
 * Jika diberikan sebuah kertas gambar dengan ukuran 𝑃 × 𝑄, tugas Anda adalah menentukan ukuran
 * kertas setelah dilakukan pelipatan sebanyak 𝑀 kali. Jika panjang sisi yang akan dilipat adalah
 * bilangan ganjil, maka hasil pelipatan adalah berupa pembulatan ke bawah. Misalnya jika ukuran
 * panjang yang akan dilipat adalah 11, maka setelah lipatan ukuran tersebut menjadi 5.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Baris pertama masukan adalah bilangan bulat 𝑁 yang menyatakan banyaknya kertas yang dimiliki
 * oleh Inneo. Kemudian 𝑁 baris berikutnya masing-masing terdiri dari tiga buah bilangan positif 𝑃,
 * 𝑄, dan 𝑀. Nilai dari 𝑃, 𝑄, 𝑀, dan 𝑁 adalah bilangan bulat serta masing-masing bernilai antara 1
 * sampai 10 000. Untuk setiap ukuran kertas yang diberikan, program Anda harus mengeluarkan
 * ukuran kertas setelah dilakukan 𝑀 kali pelipatan dengan ketentuan ukuran yang lebih besar dicetak
 * terlebih dahulu.
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
 * 120 80 3<br/>
 * 3 2 50<br/>
 * 3 7 2<br/>
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
 * 40 30<br/>
 * 0 0<br/>
 * 3 1<br/>
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
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        while (n-- > 0) { // time & space complexity: O(n)

            String[] data = in.nextLine().trim().split(" ");
            if (data.length < 3) throw new IllegalStateException("Input must be P Q and M");

            // record the execution start time
            long startTime = System.nanoTime();

            int m = Integer.parseInt(data[2]);
            int p = (int) Math.floor(Integer.parseInt(data[0]) / Math.pow(2, m % 2 == 0 ? m / 2 : (m + 1) / 2));
            int q = (int) Math.floor(Integer.parseInt(data[1]) / Math.pow(2, m % 2 == 0 ? m / 2 : (m - 1) / 2));
            System.out.format("%n%d %d", Math.max(p, q), Math.min(p, q));

            // print the runtime information
            ExecutionTimeHelper.printExecutionTime(startTime);
            MemoryUsageHelper.printMemoryUsage();
            System.out.println();
        }

        in.close();
    }
}
