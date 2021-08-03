package pre_elimination.challenge_03;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;

import java.util.Scanner;

/**
 * <h1>Hitung Penjumlahan</h1>
 * <small>
 * Time limit: 1.5 second / test case<br/>
 * Memory limit: 256 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Inneo gemar sekali menghitung terutama pada penjumlahan. Ayahnya kemudian berinisiatif
 * mengajak dia bermain hitung jumlah dari bilangan-bilangan pada sebuah matriks dua dimensi.
 * Namun, ternyata permainannya sangat membosankan karena Inneo selalu bisa menjawab dengan
 * baik. Oleh sebab itu ayahnya mencoba meminta Inneo untuk menghitung jumlah dari bilanganbilangan pada sebuah sub-matriks dari sebuah matriks dua dimensi. Misalnya diberikan sebuah
 * matriks dua dimensi 𝑁 × 𝑀, di mana 𝑁 adalah banyak baris yang dinomori dari indeks 1 sampai
 * 𝑁 dan 𝑀 merupakan banyaknya kolom yang dinomori dari indeks 1 sampai 𝑀, contohnya sebagai
 * berikut:
 * </p>
 * <p>
 * <code>
 * 5 5 6 4 1<br/>
 * 6 5 6 1 2<br/>
 * 3 3 3 2 3<br/>
 * 1 5 2 3 1<br/>
 * 4 3 3 1 4<br/>
 * </code>
 * </p>
 * <p>
 * Kemudian oleh ayahnya, Inneo diminta untuk menghitung jumlah bilangan-bilangan submatriks
 * (daerah yang diarsir) seperti berikut:
 * </p>
 * <p>
 * <code>
 * 5 5 6 4 1<br/>
 * 6 5 <b>6 1 2</b><br/>
 * 3 3 <b>3 2 3</b><br/>
 * 1 5 <b>2 3 1</b><br/>
 * 4 3 3 1 4<br/>
 * </code>
 * </p>
 * <p>
 * Sehingga dengan mudah, Inneo menjawab 23. Namun selanjutnya Inneo diminta menghitung
 * jumlah bilang-bilangan submatriks lainnya sebanyak 𝑄 kali. Karena kebingungan akhirnya dia
 * mencoba meminta bantuan Anda untuk membuat program supaya dia dengan mudah menjawab
 * pertanyaan ayahnya.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Baris pertama masukan terdiri dari tiga buah bilangan 𝑁, 𝑀, dan 𝑄, dengan 1 ≤ 𝑁, 𝑀 ≤ 10 000
 * dan 1 ≤ 𝑄 ≤ 100 000. 𝑁 buah baris berikutnya masing-masing berisi 𝑀 buah bilangan 𝐴𝑖𝑗
 * (0 ≤ 𝐴𝑖𝑗 ≤ 10 000) yang dipisahkan dengan spasi yang menyatakan nilai elemen matriks pada
 * baris ke-𝑖 dan kolom ke-𝑗. 𝑄 baris berikutnya masing-masing berisi empat buah bilangan 𝑋1, 𝑌1,
 * 𝑋2, dan 𝑌2 yang dipisahkan spasi di mana 1 ≤ 𝑋1 ≤ 𝑋2 ≤ 𝑁 dan 1 ≤ 𝑌1 ≤ 𝑌2 ≤ 𝑀. Nilai (𝑋1, 𝑌1)
 * merupakan posisi indeks elemen submatriks paling kiri-atas dan nilai (𝑋2, 𝑌2) merupakan posisi
 * indeks elemen submatriks paling kanan-bawah. Pada setiap nilai pasangan {(𝑋1, 𝑌1), (𝑋2, 𝑌2)}
 * program harus mengeluarkan nilai hasil penjumlahkan bilang-bilangan pada submatriks.
 * Dipastikan bahwa nilai {(𝑋1, 𝑌1), (𝑋2, 𝑌2)} tidak akan melebihi nilai maksimal indeks matriks pada
 * baris dan kolom yang bersesuaian.
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
 * 5 5 3<br/>
 * 5 5 6 4 1<br/>
 * 6 5 6 1 2<br/>
 * 3 3 3 2 3<br/>
 * 1 5 2 3 1<br/>
 * 4 3 3 1 4<br/>
 * 2 3 4 5<br/>
 * 1 1 2 2<br/>
 * 2 1 2 5<br/>
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
 * 23<br/>
 * 21<br/>
 * 20<br/>
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

        final int n = Math.min(in.nextInt(), 10000);
        final int m = Math.min(in.nextInt(), 10000);
        final int q = Math.min(in.nextInt(), 100000);
        final int[][] a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = Math.min(in.nextInt(), 10000);
            }
        }

        for (int i = 0; i < q; i++) {
            final int x1 = in.nextInt() - 1, y1 = in.nextInt() - 1, x2 = in.nextInt() - 1, y2 = in.nextInt() - 1;
            final long startTime = System.nanoTime();
            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    sum += a[j][k];
                }
            }
            System.out.print(sum);
            ExecutionTimeHelper.printExecutionTime(startTime);
            MemoryUsageHelper.printMemoryUsage();
        }

        in.close();
    }
}
