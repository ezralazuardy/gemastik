package pre_elimination.challenge_02;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;
import library.Reader;

import java.math.BigInteger;

/**
 * <h1>Giveaway</h1>
 * <small>
 * Time limit: 1 second / test case<br/>
 * Memory limit: 16 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Sultan Said adalah pemimpin Kesultanan Dayeuh Kolot. Ia suka membagikan barang-barang
 * tertentu secara cuma-cuma kepada warganya. Kegiatan yang dilakukannya merupakan suatu
 * bentuk giveaway yang dilakukan agar rakyatnya setia dan mendukung kepemimpinan Sang Sultan.
 * Daerah tempat Sultan Said melakukan kegiatan giveaway berbeda-beda dari waktu ke waktu.
 * Ketika melakukan kegiatan giveaway ini, Sang Sultan juga sering memberikan pertanyaan sebagai
 * bentuk sayembara. Pemenang dari sayembara ini akan diberi hadiah khusus, contohnya seperti
 * dijadikan pegawai kesultanan di istana milik Sultan Said.
 * Sultan Said suka sekali menanyakan teka-teki terkait banyaknya cara pemberian barang pada
 * giveaway yang dilakukannya. Misalkan Sultan Said memiliki 𝑁 buah barang identik
 * (dengan 1 ≤ 𝑁 ≤ 105) yang akan dibagikan kepada 𝑚 warga (dengan 1 ≤ 𝑚 ≤ 105) yang
 * dilabeli dengan 1,2, ⋯ , 𝑚 dengan syarat setiap warga 𝑖 memperoleh minimal 𝑎𝑖 (0 ≤ 𝑎𝑖 ≤ 105)
 * barang tersebut. Pada sayembara ini, Anda diminta untuk menentukan banyaknya cara pembagian
 * barang yang dapat dilakukan Sultan Said kepada orang-orang tersebut.
 * Sebagai contoh, misalkan Sultan Said memiliki 10 barang identik yang akan dibagikan kepada
 * tiga orang, sebutlah orang pertama, kedua, dan ketiga. Misalkan orang pertama setidaknya harus
 * memperoleh 5 barang yang dibagikan, orang kedua setidaknya harus memperoleh 3 barang, dan
 * orang ketiga setidaknya harus memperoleh 1 barang. Ada tiga kemungkinan cara pembagian
 * berbeda yang dapat dilakukan Sultan Said, yaitu:
 * </p>
 * <p>
 * <ol>
 * <li>Cara 1: orang pertama memperoleh 5 barang, orang kedua memperoleh 3 barang, dan
 * orang ketiga memperoleh 2 barang.</li>
 * <li>Cara 2: orang pertama memperoleh 5 barang, orang kedua memperoleh 4 barang, dan
 * orang ketiga memperoleh 1 barang.</li>
 * <li>Cara 3: orang pertama memperoleh 6 barang, orang kedua memperoleh 3 barang, dan
 * orang ketiga memperoleh 1 barang.</li>
 * </ol>
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan terdiri dari dua baris. Baris pertama adalah bilangan 𝑁 yang menyatakan banyaknya
 * barang yang dibagikan oleh Sultan Said, dengan batasan 1 ≤ 𝑁 ≤ 105.
 * Baris kedua berisi memuat 𝑚 bilangan bulat 𝑎1, 𝑎2, … , 𝑎𝑚 yang dipisahkan dengan spasi yang menyatakan banyak barang
 * minimal yang diterima oleh warga 𝑖. Nilai 𝑚 harus dibaca dari format masukan (tidak
 * diinformasikan secara eksplisit) dan memenuhi 1 ≤ 𝑚 ≤ 105.
 * Kemudian nilai dari 𝑎𝑖 untuk setiap 𝑖 = 1, … , 𝑚 adalah bilangan bulat yang memenuhi 0 ≤ 𝑎𝑖 ≤ 105.
 * Keluaran program adalah sebuah bilangan yang menyatakan banyaknya cara pembagian barang
 * yang dilakukan Sultan Said dengan ketentuan yang telah disebutkan sebelumnya. Karena jawaban
 * yang dihasilkan nilainya bisa sangat besar, jawaban yang diberikan direduksi ke dalam modulo
 * 1000 000 007.
 * </p>
 * <p>
 * <table style="width: 100%;">
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Masukkan 1</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 10<br/>
 * 5 3 1<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran 1</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 3<br/>
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
 * <h3>Masukkan 2</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 20<br/>
 * 4 4 4 4 4<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran 2</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 1<br/>
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
 * <h3>Masukkan 3</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 20<br/>
 * 2 2 2 2 2<br/>
 * </code>
 * </td>
 * </tr>
 *
 * <tr>
 * <td style="text-align: center;">
 * <h3>Keluaran 3</h3>
 * </td>
 * <td style="padding: 14px;">
 * <code>
 * 1001<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * <h2>Solution</h2>
 * Worst case time & space complexity:<code><b> O(</b></code>
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
        final Reader in = new Reader();

        final int n = Integer.parseInt(in.nextLine());

        final String[] data = in.nextLine().trim().split(" ");

        in.close();

        final long startTime = System.nanoTime();

        // calculate the sum of array
        int sum = 0;
        for (String entry : data) sum += Integer.parseInt(entry);

        // calculate the n remainder
        int remainder = n - sum;

        // calculate the a
        int a = remainder + data.length - 1;

        // calculate using below formula
        // a! / ((remainder)! * (a - remainder)!)
        // where n = giveaway price
        // where a = remainder + m - 1
        // where m = total of people joining giveaway
        System.out.println(factorial(a).divide(factorial(remainder).multiply(factorial(a - remainder))).mod(BigInteger.valueOf(1000000007)));

        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }

    /**
     * Perform a factorial using Dynamic Programming (BigInteger data)
     *
     * @param n int
     * @return BigInteger
     */
    private static BigInteger factorial(int n) {
        final BigInteger[] data = new BigInteger[n + 1];
        if (n < 2) return BigInteger.ONE;
        data[0] = BigInteger.ONE;
        data[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            data[i] = data[i - 1].multiply(BigInteger.valueOf(i));
        return data[n];
    }
}
