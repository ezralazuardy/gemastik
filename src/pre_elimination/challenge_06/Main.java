package pre_elimination.challenge_06;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Mengambil Spesimen Acak</h1>
 * <small>
 * Time limit: 0.5 second / test case<br/>
 * Memory limit: 16 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Margo dan Ganesh adalah dua orang mahasiswa tingkat akhir yang sedang melakukan penelitian
 * terkait virologi di sebuah lembaga riset. Margo ditugasi untuk mengambil sampel atau spesimen
 * dari inang (manusia) secara langsung, sedangkan Ganesh bertugas untuk melabeli spesimen-spesimen
 * yang diambil Margo.
 * </p>
 * <p>
 * Setiap spesimen akan disimpan dalam tempat khusus yang disebut vacutainer dan diberi label.
 * Bentuk vacutainer dapat dilihat pada Gambar 1. Pengambilan spesimen dibedakan berdasarkan
 * lokasi di mana spesimen tersebut diambil. Untuk setiap lokasi pengambilan spesimen yang
 * terlibat, Margo setidaknya mengambil satu spesimen.
 * </p>
 * <p>
 * Margo dan Ganesh sering mengalami kendala komunikasi yang menyebabkan masalah terjadi
 * pada pelabelan spesimen. Hal ini mengakibatkan Ganesh harus mengerjakan pelabelan ulang
 * pada spesimen yang diambil Margo. Misalkan Margo mengambil spesimen pada 𝑁 lokasi
 * berbeda (1 ≤ 𝑁 ≤ 10 000) dan pada setiap lokasi ke-𝑖 Margo mengambil sebanyak 𝑎𝑖
 * spesimen  dengan 1 ≤ 𝑎𝑖 ≤ 100. Margo sering kali lupa atau salah melabeli spesimen-spesimen yang
 * diambilnya.
 * </p>
 * <p>
 * Untungnya atasan di lembaga riset di mana Margo dan Ganesh bekerja memberi kelonggaran.
 * Beliau mengatakan bahwa mereka cukup memastikan bahwa dari 𝑁 lokasi berbeda yang terlibat
 * dalam pengambilan spesimen, setidaknya setiap lokasi cukup diwakili oleh sebuah sampel saja.
 * </p>
 * <p>
 * Untuk mempermudah Ganesh melakukan pelabelan, Margo berencana membuang beberapa
 * spesimen yang diambilnya namun dengan tetap memperhatikan bahwa setidaknya setiap lokasi
 * berbeda diwakili oleh minimal sebuah sampel. Tugas Anda adalah menentukan banyak minimal
 * spesimen yang harus diambil Margo untuk memastikan hal ini.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan hanya terdiri dari sebuah baris yang memuat 𝑁 bilangan bulat 𝑎𝑖
 * (dengan 1 ≤ 𝑖 ≤ 𝑁 dan 1 ≤ 𝑁 ≤ 10 000) yang dipisahkan dengan spasi. Informasi mengenai 𝑁 harus dibaca dari
 * masukan. Setiap bilangan 𝑎𝑖 untuk 1 ≤ 𝑖 ≤ 𝑛 memenuhi 1 ≤ 𝑎𝑖 ≤ 100. Bilangan 𝑎𝑖 menyatakan
 * banyaknya spesimen yang diambil Margo pada lokasi ke-𝑖.
 * </p>
 * <p>
 * Keluaran program adalah sebuah bilangan yang menyatakan banyak spesimen minimal yang
 * harus diambil Margo untuk memastikan bahwa setiap lokasi pengambilan spesimen diwakili oleh
 * setidaknya sebuah sampel.
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
 * 2 2<br/>
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
 * 4 5<br/>
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
    public static void main(String[] args) throws IllegalAccessException {
        final Scanner in = new Scanner(System.in);

        final String[] data = in.nextLine().trim().split(" ");

        in.close();

        final long startTime = System.nanoTime();

        List<Integer> a = new ArrayList<>();

        for (String entry : data) a.add(Math.min(Math.max(Integer.parseInt(entry), 1), 100));

        if (a.size() < 1) throw new IllegalAccessException("Minimal n adalah 1!");

        if (a.size() > 10000) a = a.subList(0, 10000 - 1);

        a.sort(Collections.reverseOrder());

        System.out.println(a.get(0) + 1);

        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }
}
