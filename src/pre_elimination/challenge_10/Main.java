package pre_elimination.challenge_10;

import helper.ExecutionTimeHelper;
import helper.MemoryUsageHelper;
import library.Reader;

import java.io.IOException;
import java.util.Arrays;

/**
 * <h1>Kurator Museum</h1>
 * <small>
 * Time limit: 0.1 second / test case<br/>
 * Memory limit: 150 MB
 * </small>
 * <br/><br/><hr/><br/>
 * <h2>Deskripsi Masalah</h2>
 * <p>
 * Sudah cukup lama lukisan karya pelukis terkenal dipamerkan dalam museum Padi Indonesia.
 * Sudah saatnya dilakukan penyegaran dengan mengatur ulang letak lukisan-lukisan tersebut. Kali
 * ini pak kurator museum ingin agar lokasi lukisan kali ini sangat berbeda dari sebelumnya jika
 * dihitung dari harga dari lukisan yang digantung.
 * </p>
 * <p>
 * Jika sebelumnya harga dari lukisan yang digantung adalah 𝑃 = 𝑝1, 𝑝2, ⋯ , 𝑝𝑛 , maka setelah
 * disusun ulang harga lukisan adalah 𝑄 = 𝑞1, 𝑞2, ⋯ , 𝑞𝑛 . Nilai perbedaan lukisan dihitung
 * berdasarkan formula 𝑑𝑖𝑓𝑓(𝑃,𝑄) = ∑ 𝑛 𝑖=1 |𝑝𝑖 − 𝑞𝑖|.
 * </p>
 * <p>
 * Bagaimana susunan lukisan yang baru agar diperoleh perbedaan yang maksimum? Perlu dicatat,
 * kurator menginginkan lukisan yang lebih berharga diusahkan ditampilkan lebih dulu.
 * </p>
 * <p>
 * <h2>Format Masukan dan Keluaran</h2>
 * Masukan terdiri dari dua baris. Baris pertama adalah nilai integer positif n, 0 < 𝑛 ≤ 100000,
 * jumlah lukisan yang dipajang. Baris berikutnya berisi satu deret n bilangan positif yang
 * menyatakan P yaitu nilai dari setiap lukisan yang dipajang, dimulai dari lukisan pertama s.d.
 * lukisan ke-n, dimana 0 < 𝑝𝑖 ≤ 100000.
 * </p>
 * <p>
 * Keluaran adalah satu deret n bilangan positif yang menyatakan Q, yaitu daftar harga lukisan
 * berdasarkan susunan baru lukisan yang dipajang.
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
 * 4<br/>
 * 1 3 2 4<br/>
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
 * 4 2 3 1<br/>
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
 * 5<br/>
 * 3 2 2 2 3<br/>
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
 * 2 3 3 2 2<br/>
 * </code>
 * </td>
 * </tr>
 *
 * </table>
 * </p>
 * <p>
 * Penjelasan: Susunan awal P=1, 3, 2, 4, dan susunan yang baru untuk contoh pertama adalah Q=4,
 * 2, 3, 1 yang memberikan perbedaan maksimum 𝑑𝑖𝑓𝑓(𝑃,𝑄) = |1 − 4| + |3 − 2| + |2 − 3| + |4 − 1| = 8
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
    public static void main(String[] args) throws IOException {
        final Reader in = new Reader();

        final int[] p = new int[Math.min(Math.max(in.nextInt(), 0), 100000)];

        for (int i = 0; i < p.length; i++) p[i] = Math.min(Math.max(in.nextInt(), 0), 100000);

        in.close();

        final long startTime = System.nanoTime();

        rearrange(p);

        ExecutionTimeHelper.printExecutionTime(startTime);
        MemoryUsageHelper.printMemoryUsage();
    }

    /**
     * Rearrange array <code>p</code> based on maximum difference
     *
     * @param p int[]
     */
    private static void rearrange(int[] p) {

        final int[] sorted = p.clone();

        Arrays.sort(sorted);

        for (int i = 0, j = p.length - 1; i <= p.length / 2; i++) {
            if (p[i] != sorted[i]) continue;
            final int temp = sorted[i];
            sorted[i] = sorted[j];
            sorted[j] = temp;
            j--;
        }

        for (int i : sorted) System.out.format("%d ", i);
        System.out.println();
    }
}
